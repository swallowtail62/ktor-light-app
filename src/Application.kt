package com.swallowtail

import com.swallowtail.adapter.controller.userController
import com.swallowtail.db.initializeDb
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.jackson.jackson
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    initializeDb()

    val server =
        embeddedServer(Netty, port = 8080, module = Application::module)
    server.start(wait = true)
}

fun Application.module() {
    install(DefaultHeaders)
    install(ContentNegotiation) {
        jackson {
        }
    }
    routing {
        userController()
    }
}
