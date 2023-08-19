package io.git.kafka.simple

import org.junit.jupiter.api.Test
import kotlin.math.min

class SimpleConsumerTest(){

        val consumer = SimpleConsumer("junnyland")

        @Test
        fun subscribe() {
            consumer.subscribe()

        }

    @Test
    fun quetion(){

    }
}