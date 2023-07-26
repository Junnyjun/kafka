package io.git.kafka.streams

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StreamsConsumerTest(){

            val consumer = StreamsConsumer("junnyland")

            @Test
            fun subscribe() {
                consumer.stream()

                println()
            }
}