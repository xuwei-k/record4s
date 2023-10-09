#!/bin/env bash

set -xe

ROOT="$(cd $(dirname "$0")/..; pwd)"
cd "$ROOT"

OUT_DIR="target/benchmark"
OPTIONS="-wi 10 -i 20 -t 1 -f 10"

sbt=sbt

OUTPUTS=()

run() {
    PROJECT=$1
    TARGET=$2
    FEATURE=$3

    mkdir -p "${OUT_DIR}/${TARGET}"
    OUTPUT="${OUT_DIR}/${TARGET}/${FEATURE}.json"

    $sbt "${PROJECT} / Jmh / run $OPTIONS ${TARGET}.${FEATURE} -rf json -rff \"../../${OUTPUT}\""
    OUTPUTS+=("$OUTPUT")
}

to_json_rows() {
    jq -s '[ .[] | {
        benchmark:.benchmark,
        target: .benchmark | sub("^benchmark[.](?<t>[^.]+)[.].*$"; "\(.t)"),
        feature: .benchmark | sub("^benchmark[.][^.]+[.](?<f>[^.]+)[.].*$"; "\(.f)"),
        index: .benchmark | sub("^.*[^0-9](?<x>[0-9]+)$"; "\(.x)") | tonumber,
        score: (.primaryMetric.rawData[] | map({value:.}))[] | .value
    } ]'
}

[ "$1" = "-0" ] && { # dry run
    shift
    sbt=:
}

[ "$1" = "-1" ] && { # just run once for test
    shift
    OPTIONS="-wi 0 -i 1 -t 1 -f 1"
}

[ -n "$1" ] && [ -n "$2" ] && [ -n "$3" ] && {
    run "$1" "$2" "$3"
    CHART_INPUT="${OUT_DIR}/${FEATURE}_${TARGET}.json"
    jq '.[]' "${OUTPUT}" | to_json_rows > "${CHART_INPUT}"
    exit
}

run_feature() {
    FEATURE="$1"
    run "benchmark_3"    "record4s"     "${FEATURE}"
    run "benchmark_3"    "caseclass"    "${FEATURE}"
    run "benchmark_3"    "map"          "${FEATURE}"
    run "benchmark_2_13" "shapeless"    "${FEATURE}"
    run "benchmark_2_11" "scalarecords" "${FEATURE}"

    CHART_INPUT="${OUT_DIR}/${FEATURE}.json"

    for output in ${OUTPUTS[@]}; do
        jq '.[]' "${output}"
    done | to_json_rows > "${CHART_INPUT}"

    OUTPUTS=()
}

run_feature "FieldAccess"
