java_binary(
    name = "command_line",
    srcs = ["EchoClient.java"],
    main_class = "EchoClient",
    runtime_deps = [
        "@io_grpc_grpc_java//netty",
    ],
    deps = [
        "//proto:transmission_object_java_proto",
        "//proto:transceiver_java_proto",
        "//proto:transceiver_java_proto_grpc",
        "@io_grpc_grpc_java//api",
    ]
)