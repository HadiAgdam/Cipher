package models


class KeySet private constructor(private val keys: List<Key>) {

    companion object {

        fun isValid(string: String) = string.split(" ").all { Key.isValid(it) }

        private fun getKeys(string: String) = string.split(" ").mapNotNull { Key.parse(it) }

        fun parse(string: String): KeySet? = if (isValid(string)) KeySet(getKeys(string))
        else null
    }


    fun get(index: Int): Int {
        var r = 0
        for (key in keys.indices)
            r += keys[key].get(key, index)
        return r
    }
}


// key :
//      1-2-3-4

// keySet :
//      1-2-3-4 1-2-3-4 1-2-3-4
