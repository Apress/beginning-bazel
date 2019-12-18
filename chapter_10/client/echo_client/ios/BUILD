load("@build_bazel_rules_apple//apple:ios.bzl", "ios_application")
load("@build_bazel_rules_swift//swift:swift.bzl", "swift_library")
 
swift_library(
    name = "Lib",
    srcs = [
        "AppDelegate.swift",
        "MainViewController.swift",
    ],
    deps = [
        "//proto:transmission_object_swift_proto",
        "//proto:transceiver_swift_proto",
        "//proto:transceiver_swift_proto_grpc",
    ]
)

ios_application(
    name = "EchoClient",
    bundle_id = "com.beginning-bazel.echo-client",
    families = ["iphone"],
    infoplists = [":Info.plist"],
    minimum_os_version = "11.0",
    deps = [":Lib"],
)
