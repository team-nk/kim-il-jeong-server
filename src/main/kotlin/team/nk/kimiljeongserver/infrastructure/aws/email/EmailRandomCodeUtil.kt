package team.nk.kimiljeongserver.infrastructure.aws.email

import java.security.SecureRandom


class EmailRandomCodeUtil(
    private val random: SecureRandom
) {

    fun generateCode(): String {
        val randomList = ArrayList<Char>()
        var codeList = ""

        for (n in '0'..'9') {
            randomList.add(n)
        }

        for (n in 'a'..'z') {
            randomList.add(n)
        }

        for (n in 'A'..'Z') {
            randomList.add(n)
        }

        for (i in 1..6) {
            codeList += randomList[random.nextInt(randomList.size)]
        }

        return codeList
    }
}
