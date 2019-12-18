load("@io_bazel_rules_go//go:def.bzl", "go_binary", "go_library", "go_test")

java_binary(
    name = "HelloWorld",
    srcs = [
        "HelloWorld.java",
    ],
    deps = [
        ":LibraryExample"
    ]
)

java_library(
    name = "LibraryExample",
    srcs = ["IntMultiplier.java"],
)

java_test(
    name = "LibraryExampleTest",
    srcs = [
        "IntMultiplierTest.java",
    ],
    deps = [
        ":LibraryExample",
        "//third_party:junit4",
    ],
    test_class = "IntMultiplierTest",
)

go_binary(
    name = "hello_world_go",
    srcs = [
        "hello_world.go",
    ],
)
