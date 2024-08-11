package test.kotlin

import main.kotlin.model.Password
import org.junit.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PasswordTest {


    @ParameterizedTest
    @CsvSource(
        "Hello"
    )
    fun testValue(text: String) {
        val p = Password.parse(text)

        println(p!!.passValue)

        for (i in 0 until 20)
            println(p.getValue(i))


    }

}