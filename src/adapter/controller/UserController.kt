package com.swallowtail.adapter.controller

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.userController() {
    route("/user") {
        get {
            call.respond(HttpStatusCode.OK, "GET ok")
        }
        post {
            call.respond(HttpStatusCode.OK, "POST ok")
        }
    }
}
