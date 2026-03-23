package com.arnav.week1.day1

fun greet(name: String?): String {
    val display = name?.uppercase() ?: "STRANGER"
    return "Hello, $display"
}

// Safe navigation chain — realistic for config objects
data class DatabaseConfig(val host: String, val port: Int)
data class AppConfig(val db: DatabaseConfig?)

fun getDbHost(config: AppConfig?): String =
    config?.db?.host ?: "localhost"

fun main() {
    // Basic nullable
    println(greet("arnav"))   // Hello, ARNAV
    println(greet(null))      // Hello, STRANGER

    // Chained safe calls
    val fullConfig = AppConfig(db = DatabaseConfig("prod.cognite.com", 5432))
    val noDbConfig = AppConfig(db = null)
    val nullConfig: AppConfig? = null

    println(getDbHost(fullConfig))   // prod.cognite.com
    println(getDbHost(noDbConfig))   // localhost
    println(getDbHost(nullConfig))   // localhost
}