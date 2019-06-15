package com.swallowtail.service

import com.swallowtail.adapter.repository.UserRepository
import com.swallowtail.domain.entity.User
import com.swallowtail.domain.msg.GetUserRespMsg

class UserService(private val userRepository: UserRepository) {
    fun getAllUser(): GetUserRespMsg {
        val userDtoList = userRepository.getAll().map(User::toUserDto)
        return GetUserRespMsg(userDtoList)
    }

    fun createUser(name: String, age: Int) {
        userRepository.create(name, age)
    }
}
