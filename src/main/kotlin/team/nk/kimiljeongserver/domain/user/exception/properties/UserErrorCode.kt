package team.nk.kimiljeongserver.domain.user.exception.properties

import org.springframework.http.HttpStatus
import team.nk.kimiljeongserver.global.error.ErrorProperty

enum class UserErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found"),
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "User Already Exists"),

    PASSWORD_MISS_MATCHED(HttpStatus.UNAUTHORIZED, "Password Miss Matched"),
    CODE_MISS_MATCHED(HttpStatus.UNAUTHORIZED, "Code Miss Matched");

    override fun status() = status.value()
    override fun message() = message
}
