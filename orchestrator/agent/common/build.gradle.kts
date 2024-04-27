plugins {
    kotlin("jvm")
    application
}
dependencies {
    implementation(Library.protobuf)
}
dependencies{
    implementation(project(":orchestrator:model"))
    implementation(project(":orchestrator:external"))
}