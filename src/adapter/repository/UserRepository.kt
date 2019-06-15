package com.swallowtail.adapter.repository

import com.swallowtail.domain.entity.User
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepository {
    fun getAll(): Iterable<User> {
        return transaction {
            User.all()
        }
    }

    fun create(name: String, age: Int) {
        transaction {
            User.new {
                this.name = name
                this.age = age
            }
        }
    }
}
