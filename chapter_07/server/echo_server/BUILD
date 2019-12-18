load("@io_bazel_rules_go//go:def.bzl", "go_binary")
go_binary(
    name = "echo_server",
    srcs = ["echo_server.go"],
    deps = [
        "//proto:transmission_object_go_proto",
         "@com_github_golang_protobuf//proto:go_default_library",
    ],
)