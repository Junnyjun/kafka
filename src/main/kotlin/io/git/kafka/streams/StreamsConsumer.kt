package io.git.kafka.streams

import io.git.kafka.simple.SimpleProducer
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import java.util.*


private const val SEVER_A: String = "main.junnyland.com:29092"
private const val SEVER_B: String = "main.junnyland.com:39092"
private const val SEVER_C: String = "main.junnyland.com:49092"

private const val NAME: String = "junnyland"

data class StreamsConsumer(
    private val topic: String,
) {
    fun stream(): Unit = KafkaStreams(
        StreamsBuilder()                                                                                     
            .also { it.stream<String, String>("junnyland_Stream") }
            .also { it to "junnyland_Stream_copy" }
            .build(),
        config
    ).start()

    fun consume(): Unit = KafkaConsumer<String, String>(config).use {
        it.subscribe(listOf(topic))
        while (true) {
            it.poll(1000).forEach { record ->
                println("key: ${record.key()}, value: ${record.value()}")
            }
        }
    }

    private companion object Config {
        val config = Properties().apply {
            put(StreamsConfig.APPLICATION_ID_CONFIG, NAME)
            put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "$SEVER_A,$SEVER_B,$SEVER_C")
            put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass)
            put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().javaClass)
        }
    }
}