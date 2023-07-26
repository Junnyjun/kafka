package io.git.kafka.producer

import io.git.kafka.simple.SimpleProducer
import org.junit.jupiter.api.Test

class SimpleProducerTest {

    val producer = SimpleProducer("junnyland")
    @Test
    fun send() {
        val send = producer.send("Hello Kafka")

        val get = send.get()

        println(get)
    }
}