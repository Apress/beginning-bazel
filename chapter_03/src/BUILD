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
