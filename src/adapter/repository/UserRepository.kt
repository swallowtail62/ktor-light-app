package com.swallowtail.adapter.repository

import com.swallowtail.domain.entity.User
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepository {
    fun getAll(): List<User> {
        return transaction {
            User.all().toList()
        }
    }

    fun create(name: String, age: Int): User {
        return transaction {
            User.new {
                this.name = name
                this.age = age
            }
        }
    }
}
