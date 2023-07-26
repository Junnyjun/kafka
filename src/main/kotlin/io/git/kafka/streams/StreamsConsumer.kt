package io.git.kafka.streams

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import java.time.Duration
import java.util.*


private const val SEVER_A: String = "main.junnyland.com:29092"
private const val SEVER_B: String = "main.junnyland.com:39092"
private const val SEVER_C: String = "main.junnyland.com:49092"

private const val GROUP: String = "junnyland"

data class StreamsConsumer(
    private val topic: String,
) {
    private val kafkaProducer = KafkaConsumer<String, String>(config)

    fun subscribe() = kafkaProducer.subscribe(listOf(topic))
        .let {
            while (true) {
                kafkaProducer.poll(Duration.ofSeconds(1)).forEach {
                    println(it.value())
                }
            }
        }

    private companion object Config{
        val config = Properties().apply {
            put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "$SEVER_A,$SEVER_B,$SEVER_C")
            put(ConsumerConfig.GROUP_ID_CONFIG, GROUP)
            put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)
            put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)
        }
    }
}
