package team.nk.kimiljeongserver.infrastructure.aws.email

class EmailRandomCodeUtil {

    fun generateCode(): Int {
        return (100..9999).random()
    }
}
