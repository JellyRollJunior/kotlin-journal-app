package com.example.kotlinjournal

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun generate_dice_roll() {
        val myDice = Dice(6)
        val diceRoll = myDice.roll()

        assertTrue("Value of diceRoll was not between 1 and 6",diceRoll in 1..6)
    }
}