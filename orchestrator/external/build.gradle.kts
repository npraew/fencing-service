import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    idea
    id("com.google.protobuf")
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.protobuf:protobuf-kotlin:3.19.4")
    implementation("com.google.protobuf:protobuf-java-util:3.19.4")
//    implementation("io.grpc:grpc-stub:1.15.1")
//    implementation("io.grpc:grpc-protobuf:1.15.1")

//    if (JavaVersion.current().isJava9Compatible()) {
//        // Workaround for @javax.annotation.Generated
//        // see: https://github.com/grpc/grpc-java/issues/3633
//        implementation("javax.annotation:javax.annotation-api:1.3.1")
//    }

    // Extra proto source files besides the ones residing under
    // "src/main".
//    protobuf(files("lib/protos.tar.gz"))
//    protobuf(files("ext/"))

//    testImplementation("junit:junit:4.13.2")
    // Extra proto source files for test besides the ones residing under
    // "src/test".
//    testProtobuf(files("lib/protos-test.tar.gz"))

}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }
}

//java {
//    sourceCompatibility = JavaVersion.VERSION_11
//    targetCompatibility = JavaVersion.VERSION_11
//}
//
//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
//}


protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.19.4"
    }
    generateProtoTasks {
        all().forEach {
            it.builtins {
                id("kotlin")
            }
        }
    }
}
