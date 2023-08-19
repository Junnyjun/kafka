package io.git.kafka.simple

import io.git.kafka.simple.SimpleProducer
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.UUID

class SimpleProducerTest {

    val producer = SimpleProducer("junnyland")
    @Test
    fun send() {
        val wallet = Wallet(BigDecimal(1000))
        val target:List<Money> = listOf(
            Money(UUID.randomUUID(), BigDecimal(100)),
            Money(UUID.randomUUID(), BigDecimal(200)),
            Money(UUID.randomUUID(), BigDecimal(300)),
        )
        val finalWallet = target
            .fold(wallet)
            { wallet, money -> Wallet(wallet.money - money.amount) }

        println("producer = ${producer}")
    }

    data class Money(
         val id: UUID,
         val amount: BigDecimal
    )

    data class Wallet(
         val money: BigDecimal
    )
}