package com.swallowtail

import io.ktor.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    val server =
        embeddedServer(Netty, watchPaths = listOf("example"), port = 8080, module = Application::module)
    server.start(wait = true)
}

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
}
