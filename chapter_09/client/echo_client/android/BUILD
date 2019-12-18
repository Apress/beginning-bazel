load("@rules_android//android:rules.bzl", "android_library", "android_binary")
android_library(
    name = "echo_client_android_activity",
    srcs = ["EchoClientMainActivity.java"],
    manifest = "AndroidManifest.xml",
    custom_package = "client.echo_client.android",
    resource_files = [
        "res/layout/echo_client_main_activity.xml"
    ],
    deps = [
        "//proto:transmission_object_java_proto",
        "//proto:transceiver_java_proto",
        "//proto:transceiver_java_proto_grpc",
        # "//proto:transmission_object_java_lite_proto",
        # "//proto:transceiver_java_lite_proto",
        # "//proto:transceiver_java_lite_proto_grpc",
        "@io_grpc_grpc_java//api",
        "@io_grpc_grpc_java//okhttp",
        "@io_grpc_grpc_java//stub",
    ]
)

android_binary(
    name = "echo_client_android_app",
    manifest = "AndroidManifest.xml",
    deps = [ ":echo_client_android_activity"],
    custom_package = "client.echo_client.android",
)
