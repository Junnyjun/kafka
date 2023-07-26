package io.git.kafka.simple

import org.junit.jupiter.api.Test

class SimpleConsumerTest(){

        val consumer = SimpleConsumer("junnyland")

        @Test
        fun subscribe() {
            consumer.subscribe()

        }
}