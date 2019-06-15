package com.swallowtail.db.table

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column

object Users : IntIdTable() {
    val name: Column<String> = varchar("name", 20).uniqueIndex()
    val age: Column<Int> = integer("age")
}
