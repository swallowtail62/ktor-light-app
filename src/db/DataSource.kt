package com.swallowtail.db

import com.swallowtail.adapter.repository.UserRepository
import com.swallowtail.db.table.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

private fun connectDb() {
    Database.connect("jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1;", "org.h2.Driver")
}

internal fun initializeDb() {
    connectDb()
    transaction {
        // create TBL
        SchemaUtils.create(Users)
        // insert initial data
        val names = listOf("bob", "michel", "riku", "kobayashi", "swallowtail")
        val userRepository = UserRepository()
        names.forEach { name ->
            userRepository.create(name, (18..30).random())
        }
    }
}
