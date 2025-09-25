package sandbox.fuzz

import kotlinx.fuzz.KFuzzTest
import kotlinx.fuzz.KFuzzer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MathTest {

    @Test
    fun testSanity() {
        assertTrue(true)
    }

    @KFuzzTest
    fun testAddOneAndSubtractOne(f: KFuzzer) {
        val initial = f.int(Int.MIN_VALUE .. Int.MAX_VALUE)
        val addOneResult = addOne(initial)
        val subtractOneResult = subtractOne(addOneResult)
        assertEquals(initial, subtractOneResult)
    }
}