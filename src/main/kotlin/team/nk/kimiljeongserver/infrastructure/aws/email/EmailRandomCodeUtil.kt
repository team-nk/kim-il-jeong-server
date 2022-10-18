package team.nk.kimiljeongserver.infrastructure.aws.email

class EmailRandomCodeUtil {

    fun generateCode(): Int {
        return (1000..9999).random()
    }
}
