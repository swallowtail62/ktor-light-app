package com.swallowtail.adapter.controller

import com.swallowtail.adapter.repository.UserRepository
import com.swallowtail.domain.msg.CreateUserReqMsg
import com.swallowtail.service.UserService
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.userController() {
    val userService = UserService(UserRepository())

    route("/user") {
        get {
            call.respond(HttpStatusCode.OK, userService.getAllUser())
        }

        post {
            val reqMsg = call.receive<CreateUserReqMsg>()
            userService.createUser(reqMsg.name, reqMsg.age)
            call.respond(HttpStatusCode.OK)
        }
    }
}
