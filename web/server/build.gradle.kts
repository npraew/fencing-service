plugins {

    kotlin("jvm")
    application
}


dependencies {
    implementation(group = "com.microsoft.sqlserver", name = "mssql-jdbc", version = "10.2.0.jre11")
//    implementation(group = "com.agoda.commons", name = "ag-sql-hikari", version = "3.0.0-RC1")
    implementation("io.arrow-kt:arrow-core:1.2.0")
    implementation("io.arrow-kt:arrow-fx-coroutines:1.2.0")
    implementation("io.ktor:ktor-server-core:2.3.4")
    implementation("io.ktor:ktor-server-netty:2.3.4")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}


application {
    mainClass.set("com.agoda.demo.workflow.web.server.MainKt")
}

//kotlin {
//    compilerOptions {
//        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
//    }
//}
