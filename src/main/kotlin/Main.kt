import main.kotlin.model.Password
import models.KeySet
import java.io.File
import java.security.MessageDigest


// java -jar acrypt.jar <command> <password> <keySet> <text> <hideLength>
fun main(args: Array<String>) {

    val password = Password.parse(args[1])
    val keySet = KeySet.parse(args[2])
    val text = args[3]
    val hideLength = args.size > 4 && args[4] == "1"

    if (password == null) {
        println("invalid password")
        return
    }
    if (keySet == null) {
        println("invalid keySet")
        return
    }
    println()
    println(
        when (args[0]) {
            "e" -> Cipher.encrypt(text, password, keySet, hideLength)


            "d" -> Cipher.decrypt(text, password, keySet)


            else -> "invalid command"


        }
    )
    println()
}
