package team.nk.kimiljeongserver.infrastructure.aws.email

import org.springframework.stereotype.Component
import java.security.SecureRandom

@Component
class EmailRandomCodeUtil {

    fun generateCode(): String {
        val random = SecureRandom()
        val randomList = ArrayList<Char>()
        var codeList = ""

        for (n in '0'..'9') {
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
