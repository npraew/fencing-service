plugins {

    kotlin("jvm")
    application
}

dependencies {
    implementation(Library.rabbitmq)
    implementation(Library.protobuf)
    implementation(group = "com.microsoft.sqlserver", name = "mssql-jdbc", version = "10.2.0.jre11")
//    implementation(group = "com.agoda.commons", name = "ag-sql-hikari", version = "3.0.0-RC1")
    implementation(group= "ch.qos.logback", name=  "logback-classic", version= "1.2.6")

    implementation("io.arrow-kt:arrow-core:1.2.0")
    implementation("io.arrow-kt:arrow-fx-coroutines:1.2.0")


    implementation(kotlin("reflect"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

dependencies{
    implementation(project(":orchestrator:external"))
}

application {
    mainClass.set("com.agoda.demo.workflow.orchestrator.core.MainKt")
}

//kotlin {
//    compilerOptions {
//        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
//    }
//}
