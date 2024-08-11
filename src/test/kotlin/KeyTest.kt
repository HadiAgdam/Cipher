package test.kotlin

import models.Key
import org.junit.Assert.*
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class KeyTest {

    @ParameterizedTest
    @CsvSource(
        "1-2-3",
        "1",
        "000000000000000001-1",
        "22-333-444"
    )
    fun validKey(input: String) {
        Assertions.assertTrue(Key.isValid(input))
    }

    @ParameterizedTest
    @CsvSource(
        "1--2-3",
        "abd",
        "1-2-c",
        "asdsal;kdas;ld",
        "-1",
        "1.1"
    )
    fun invalidKey(input: String) {
        Assertions.assertFalse(Key.isValid(input))
    }


    @ParameterizedTest
    @CsvSource(
        "1-2-3-4-",
        "2-3-4-5",
        "123-2-4"
    )
    fun validNums(num: String) {
        println("$num : ${Key.getNums(num)}")
    }
}