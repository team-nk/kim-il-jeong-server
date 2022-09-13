package com.example.kimiljeongdomain.error

enum class ErrorCode(
    override val errorStatus: Int,
    override val errorCode: String,
    override val errorMessage: String
) : ErrorProperty {

    METHOD_ARGUMENT_NOT_VALID(400, "GLOBAL-400-1", "Method Argument Not Valid"),
    CONSTRAINT_VIOLATION(400, "GLOBAL-400-2", "Constraint Violation"),
    DATA_INTEGRITY_VIOLATION(400, "GLOBAL-400-3", "DataIntegrity Violation"),
    ILLEGAL_ARGUMENT(400, "GLOBAL-400-4", "Illegal Argument"),
    BAD_REQUEST(400, "GLOBAL-400-5", "Bad Request"),
    INTERNAL_SERVER_ERROR(500, "GLOBAL-500-1", "Internal Server Error"),

    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),

    EXPIRED_JWT(401, "JWT-401-1", "Expired Jwt"),
    MALFORMED_JWT(401, "JWT-401-2", "Malformed Jwt"),
    SIGNATURE_JWT(401, "JWT-401-3", "Signature Jwt"),
    UNSUPPORTED_JWT(401, "JWT-401-4", "Unsupported Jwt"),
    UNEXPECTED_JWT(500, "JWT-500-1", "Unexpected Jwt"),
    VALIDATE_FAILED_JWT(401, "JWT-401-5", "Validate Failed Jwt")
}
