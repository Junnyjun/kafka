package io.git.kafka.simple

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.KStream
import java.util.*
import java.util.concurrent.Future

private const val SEVER_A: String = "main.junnyland.com:29092"
private const val SEVER_B: String = "main.junnyland.com:39092"
private const val SEVER_C: String = "main.junnyland.com:49092"

data class SimpleProducer(
    private val topic: String
) {
    private val kafkaProducer = KafkaProducer<String, String>(config)

    fun send(message: String): Future<RecordMetadata> = kafkaProducer.send(ProducerRecord(topic, message))




    private companion object Config{
        val config = Properties().apply {
            put("bootstrap.servers", "${SEVER_A},${SEVER_B},${SEVER_C}")
            put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java)
            put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java)
        }
    }
}