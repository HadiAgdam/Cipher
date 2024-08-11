package models


class Key private constructor(private val nums: List<Int>) {
    companion object {

        fun isValid(string: String) = Regex("^\\d+(-\\d+)*$").matches(string)


        fun getNums(string: String) = string.split("-").mapNotNull { it.toIntOrNull() }


        fun parse(string: String): Key? {
            return if (isValid(string)) {
                Key(getNums(string))
            } else null
        }
    }

    fun get(l: Int, index: Int): Int {
        val t = arrayListOf<Int>()
        for (n in nums) t.add(n)
        for (i in 0 until l) t.add(0)

        return t[index % t.size]
    }
}
