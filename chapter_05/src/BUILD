load("@io_bazel_rules_go//go:def.bzl", "go_binary", "go_library")

go_binary(
    name = "echo_server",
    srcs = ["echo_server.go"],
    deps = [":transmission_object_go"],
)

go_library(
    name = "transmission_object_go",
    srcs = ["transmission_object.go"],
    importpath = "transmission_object",
)

java_library(
    name = "transmission_object_java",
    srcs = ["TransmissionObject.java"],
)

java_binary(
    name = "echo_client",
    srcs = ["EchoClient.java"],
    main_class = "EchoClient",
    deps = [
        ":transmission_object_java",
        "//third_party:gson",
    ]
)