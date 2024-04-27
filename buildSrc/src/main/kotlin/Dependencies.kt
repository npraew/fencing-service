@file:Suppress("MemberVisibilityCanBePrivate")


object Versions {
    const val rabbitmq = "5.15.0"
    const val protobuf = "3.8.0"
}

object Library {
    const val rabbitmq = "com.rabbitmq:amqp-client:${Versions.rabbitmq}"
    const val protobuf = "com.google.protobuf:protobuf-java:${Versions.protobuf}"
}