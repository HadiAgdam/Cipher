import main.kotlin.model.Password
import models.KeySet

private val upperList = ('A'..'Z').toList()
private val lowerList = ('a'..'z').toList()

private val chars = upperList + lowerList


fun get(index: Int): Char {
    return if (index >= 0) {
        chars[index % chars.size]
    } else {
        chars[(chars.size + (index % chars.size)) % chars.size]
    }
}

fun indexOf(char: Char): Int {
    return chars.indexOf(char)
}


object Cipher {

    fun encrypt(text: String, password: Password, set: KeySet, hideLength: Boolean = false): String {
        var result = ""
        var t = text

        if (hideLength) {
            var s = 1
            while (s < text.length)
                s *= 2
            while (t.length < s)
                t += "*"
        }

        for (i in t.indices) {
            result += if (!chars.contains(t[i]))
                t[i]
            else
                get(indexOf(t[i]) + password.getValue(i) + set.get(i))
        }

        return result
    }

    fun decrypt(text: String, password: Password, set: KeySet): String {
        var result = ""

        for (i in text.indices) {
            result += if (!chars.contains(text[i]))
                text[i]
            else
                get(indexOf(text[i]) - password.getValue(i) - set.get(i))
        }

        return result
    }

}
