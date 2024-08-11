import main.kotlin.model.Password
import models.KeySet
fun main(args: Array<String>) {
    var password: Password? = null
    var keySet: KeySet? = null
    var text: String = ""
    var hideLength: Boolean = false

    if (args.size == 5) {
        password = Password.parse(args[1])
        keySet = KeySet.parse(args[2])
        text = args[3]
        hideLength = args[4].toBoolean()

        if (password == null || keySet == null) {
            println("Error: Invalid input. Falling back to interactive mode...")
        } else {
            when (args[0]) {
                "e" -> {
                    println(Cipher.encrypt(text, password, keySet, hideLength))
                    return
                }
                "d" -> {
                    println(Cipher.decrypt(text, password, keySet, hideLength))
                    return
                }
                else -> {
                    println("Unknown command: ${args[0]}")
                    return
                }
            }
        }
    }

    while (true) {
        if (password == null) {
            println("Enter password: ")
            password = Password.parse(readlnOrNull() ?: "")
            if (password == null) {
                println("Error: Invalid password format.")
                continue
            }
        }

        if (keySet == null) {
            println("Enter keys: ")
            keySet = KeySet.parse(readlnOrNull() ?: "")
            if (keySet == null) {
                println("Error: Invalid KeySet format.")
                continue
            }
        }

        if (text.isBlank()) {
            println("Enter text: ")
            text = readlnOrNull() ?: ""
        }

        if (!hideLength) {
            println("Hide length? (true/false): ")
            hideLength = readLine()?.toBoolean() ?: false
        }

        println("Enter command (e for encrypt, d for decrypt, q to quit): ")

        when (val command = readlnOrNull()) {
            "e" -> println(Cipher.encrypt(text, password, keySet, hideLength))
            "d" -> println(Cipher.decrypt(text, password, keySet, hideLength))
            "q" -> return
            else -> println("Unknown command: $command")
        }

        password = null
        keySet = null
        text = ""
        hideLength = false
    }
}
