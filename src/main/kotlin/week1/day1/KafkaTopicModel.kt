package com.arnav.week1.day1

//Data Class
data class KafkaTopic(
    val name: String,
    val partitions: Int,
    val replicationFactor: Int,
    val retentionMs: Long = 604_800_000L
)
//Extension Function
fun KafkaTopic.summary(): String =
    "[$name] — P:$partitions R:$replicationFactor"

//Function with `when`
fun replicationLabel(factor: Int): String = when (factor) {
    1    -> "low"
    2    -> "standard"
    else -> "high"
}

fun main() {
    val topic = KafkaTopic("events.signal", partitions = 12, replicationFactor = 3)
    println(topic.summary())
    println(replicationLabel(topic.replicationFactor))  // high
    val devTopic = topic.copy(name = "events.signal.dev", replicationFactor = 1)
    println(devTopic.summary())
    println(replicationLabel(devTopic.replicationFactor))  // low
}
