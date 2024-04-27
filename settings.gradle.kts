pluginManagement {
    // define plugin version standard
    plugins {
        kotlin("jvm") version "1.9.10"
        id("com.google.protobuf") version "0.8.19"
    }
}
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven { url = uri("https://repo-hkg.agodadev.io/agoda-maven") }
    }
    versionCatalogs {
        // *.toml files from gradle folder are supported by renovate bot
        // more -> https://github.com/renovatebot/renovate/blob/main/docs/usage/java.md#gradle-file-support

        val versionsPath = "./gradle/dependencies"

        create("agodaLibs") {
            from(files("$versionsPath/kotlin-libs.toml"))
        }
    }
}

rootProject.name = "HelloKotlinWF"

println("This is executed during the initialization phase.")

include("web:server")
include(
    "orchestrator:core",
    "orchestrator:model",
    "orchestrator:external",
    "orchestrator:agent:common",
    "orchestrator:agent:payment",
    "orchestrator:agent:flight"
)


