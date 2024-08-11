package test.kotlin

import main.kotlin.model.*
import models.Key
import models.KeySet
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CipherTest {


    @ParameterizedTest
    @CsvSource(
        "Hello",
        "steve",
        "hi",
        "qwerty",
        "000000000000000000000000000000000000000000000000000000000"
    )
    fun testEncrypt(text: String) {

        val e = Cipher.encrypt(text, Password.parse("password سلام")!!, KeySet.parse("1 22-3 3-2-4")!!)
        val d = Cipher.decrypt(e, Password.parse("password سلام")!!, KeySet.parse("1 22-3 3-2-4")!!)

        println("$text : $e : $d")

        Assertions.assertEquals(text, d)
    }


    @ParameterizedTest
    @CsvSource(
        "password سلام",
        "anotherPassword",
        "1234567890",
        "!@#$%^&*()_+-=[]{}|;':\",.<>/?",
        "emojis😊🚀💻",
    )
    fun testDifferentPasswords(passwordText: String) {
        val text = "testString"
        val keySet = KeySet.parse("1 22-3 3-2-4")!!

        val password1 = Password.parse(passwordText)!!
        val password2 = Password.parse(passwordText.reversed())!!

        val e1 = Cipher.encrypt(text, password1, keySet)
        val e2 = Cipher.encrypt(text, password2, keySet)

        println("$passwordText -> $e1")
        println("${passwordText.reversed()} -> $e2")

        Assertions.assertNotEquals(e1, e2)

        Assertions.assertEquals(text, Cipher.decrypt(e1, password1, keySet))
        Assertions.assertEquals(text, Cipher.decrypt(e2, password2, keySet))
    }


    @ParameterizedTest
    @CsvSource(
        "Hello, 1-2-3",
        "Hello, 11-2 89-73-22 94",
        "Hello, 53-31-4",
        "steve, 1-2-3",
        "steve, 11-2 89-73-22 94",
        "steve, 53-31-4",
        "hi, 1-2-3",
        "hi, 11-2 89-73-22 94",
        "hi, 53-31-4",
        "qwerty, 1-2-3",
        "qwerty, 11-2 89-73-22 94",
        "qwerty, 53-31-4",
        "000000000000000000000000000000000000000000000000000000000, 1-2-3",
        "000000000000000000000000000000000000000000000000000000000, 11-2 89-73-22 94",
        "000000000000000000000000000000000000000000000000000000000, 53-31-4"
    )
    fun testEncryptWithDifferentKeySets(text: String, keySetStr: String) {
        val password = Password.parse("Hoi")!!
        val keySet = KeySet.parse(keySetStr)!!

        val e = Cipher.encrypt(text, password, keySet)
        val d = Cipher.decrypt(e, password, keySet)

        println("$text : $e : $d")

        Assertions.assertEquals(text, d)
    }


    @Test
    fun testHideLength() {
        val p = Password.parse("password")!!
        val k = KeySet.parse("1-2-3")!!

        val e = Cipher.encrypt("test17987987979897897", p, k, true)
        val d = Cipher.decrypt(e, p, k, true)


        println("$e : $d")

    }
}

