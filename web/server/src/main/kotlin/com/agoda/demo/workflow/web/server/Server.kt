package com.agoda.demo.workflow.web.server


import io.ktor.server.engine.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import java.io.File

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        routing {
            staticFiles("/", File("web/client/dist"), index = "index.html"){
                preCompressed(CompressedFileType.GZIP)
            }
        }
    }.start(wait = true)
}