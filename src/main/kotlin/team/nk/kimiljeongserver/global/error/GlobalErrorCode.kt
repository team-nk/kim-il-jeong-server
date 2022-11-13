package team.nk.kimiljeongserver.global.error

import org.springframework.http.HttpStatus

enum class GlobalErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),

    MESSAGE_IS_REJECTED(HttpStatus.BAD_REQUEST, "Message Is Rejected"),
    
    JWT_VALIDATE_FAILED(HttpStatus.UNAUTHORIZED, "Token Validate Failed"),
    JWT_EXPIRED(HttpStatus.UNAUTHORIZED, "Jwt Token Expired"),
    JWT_SIGNATURE(HttpStatus.UNAUTHORIZED, "Invalid Signature"),
    UNEXPECTED_TOKEN(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected Token Exception"),

    CODE_NOT_FOUND(HttpStatus.NOT_FOUND, "Code Not Found"),

    IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "Image Not Found"),
    INVALID_IMAGE_EXTENSION_FORMAT(HttpStatus.UNAUTHORIZED, "Invalid Image Extension Format");

    override fun status() = status.value()
    override fun message() = message
}