package test.kotlin

import models.KeySet
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class KeySetTest {

    @ParameterizedTest
    @CsvSource(
        "1 2 3",
        "1-2 2-3 1",
        "1 1-2-3",
        "1-23-123",
    )
    fun validKeySet(input: String) {
        Assertions.assertTrue(KeySet.isValid(input))
    }

    @ParameterizedTest
    @CsvSource(
        "1*2",
        "---",
        "abvdw",
        "1 2 2-b",
        "1-b"
    )
    fun invalidKeySet(input: String) {
        Assertions.assertFalse(KeySet.isValid(input))
    }

}