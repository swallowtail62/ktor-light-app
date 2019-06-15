package com.swallowtail.domain.entity

import com.swallowtail.db.table.Users
import com.swallowtail.domain.dto.UserDto
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var name by Users.name
    var age by Users.age

    fun toUserDto(): UserDto {
        return UserDto(this.id.value, this.name, this.age)
    }
}
