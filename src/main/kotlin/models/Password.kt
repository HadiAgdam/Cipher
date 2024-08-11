package main.kotlin.model

import indexOf

class Password private constructor(private val text: String) {
    var passValue: List<Int>

    init {
        val l = arrayListOf(indexOf(text[0]) + indexOf(text[1]) + text.length)

        for (i in 1 until text.length - 1)
            l.add(indexOf(text[i - 1]) + indexOf(text[i]) + indexOf(text[i + 1]) + text.length)

        l.add(indexOf(text.last()) + indexOf(text[text.length - 1]) + text.length)

        for (i in text.indices) {
            l[i] += text[i].code
        }

        passValue = l
    }

    fun getValue(index: Int) = passValue[index % passValue.size]


    companion object {

        private fun isValid(text: String): Boolean {
            return text.isNotBlank()
        }

        fun parse(text: String): Password? {
            return if (isValid(text))
                Password(text)
            else
                null
        }
    }


    override fun toString(): String {
        return text
    }

}