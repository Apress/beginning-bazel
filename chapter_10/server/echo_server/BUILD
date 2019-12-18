load("@io_bazel_rules_go//go:def.bzl", "go_binary")
go_binary(
    name = "echo_server",
    srcs = ["echo_server.go"],
    deps = [
         "//proto:transceiver_go_proto_grpc",
         "//proto:transmission_object_go_proto",
         "@org_golang_x_net//context:go_default_library",
         "@org_golang_google_grpc//:go_default_library",
    ]
)