package team.nk.kimiljeongserver.infrastructure.aws.email

import java.util.concurrent.ThreadLocalRandom

class EmailRandomCodeUtil {

    fun generateCode(): Int {
        return ThreadLocalRandom.current().nextInt(1000, 10000)
    }
}
