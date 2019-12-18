# package(default_visibility = ["//:__pkg__"])
load("@rules_proto//proto:defs.bzl", "proto_library")
load("@io_bazel_rules_go//proto:def.bzl", "go_proto_library")

proto_library(
    name = "transmission_object_proto",
    srcs = ["transmission_object.proto"],
)

java_proto_library(
    name = "transmission_object_java_proto",
    deps = [":transmission_object_proto"],
    visibility = ["//client/echo_client:__subpackages__"],
)

go_proto_library(
    name = "transmission_object_go_proto",
    proto = ":transmission_object_proto",
    importpath = "transmission_object",
    visibility = ["//server/echo_server:__pkg__"],
)
