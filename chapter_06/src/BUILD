load("@rules_proto//proto:defs.bzl", "proto_library")

proto_library(
    name = "transmission_object_proto",
    srcs = ["transmission_object.proto"],
)

java_proto_library(
    name = "transmission_object_java_proto",
    deps = [":transmission_object_proto"],
)

java_binary(
    name = "echo_client",
    srcs = ["EchoClient.java"],
    main_class = "EchoClient",
    deps = [":transmission_object_java_proto"],
)

load("@io_bazel_rules_go//proto:def.bzl", "go_proto_library")
go_proto_library(
    name = "transmission_object_go_proto",
    proto = ":transmission_object_proto",
    importpath = "transmission_object"
)

load("@io_bazel_rules_go//go:def.bzl", "go_binary")
go_binary(
    name = "echo_server",
    srcs = ["echo_server.go"],
    deps = [
        ":transmission_object_go_proto",
         "@com_github_golang_protobuf//proto:go_default_library",
    ],
)
