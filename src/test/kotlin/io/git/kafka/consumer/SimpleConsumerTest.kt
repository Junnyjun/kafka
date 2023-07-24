package io.git.kafka.consumer

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SimpleConsumerTest(){

        val consumer = SimpleConsumer("junnyland")

        @Test
        fun subscribe() {
            consumer.subscribe()

        }
}