package com.arnav.week1.day2

data class AppConfig(
    var host: String = "localhost",
    var port: Int = 8080,
    var enableMetrics: Boolean = false,
    var serviceName: String = ""
)

fun main() {

    // EXERCISE 1:
// Build an AppConfig where host="0.0.0.0", port=9090, enableMetrics=true.
// Use the most idiomatic scope function.
    val config: AppConfig = AppConfig().apply { host = "0.0.0.0"; port = 9090; enableMetrics = true }
    println(config)

// EXERCISE 2:
// Given a nullable serviceName, append ":v2" to it if non-null,
// or return "unknown:v2" if null. One expression, no if/else.
    val rawName: String? = System.getenv("SERVICE_NAME")
    val versionedName: String = rawName?.let { "$it:v2" } ?: "unknown:v2"
    println(versionedName)

// EXERCISE 3:
// Given this list of configs, log each one (println is fine)
// and return only those with port > 8080. Keep it as a single chain.
    val configs = listOf(
        AppConfig(port = 8080),
        AppConfig(port = 9090),
        AppConfig(port = 7070, enableMetrics = true)
    )
    val filtered = configs
        .onEach { println(it) }   // stdlib: like forEach but returns the collection
        .filter { it.port > 8080 }
    println(filtered)

}