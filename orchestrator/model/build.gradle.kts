import Library

plugins {
    kotlin("jvm")
    application
}



dependencies {
    implementation(Library.protobuf)
}

dependencies{
    implementation(project(":orchestrator:external"))
}