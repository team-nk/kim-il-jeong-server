package team.nk.kimiljeongserver.global.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object JwtValidateException : KimIlJeongException(
    GlobalErrorCode.JWT_VALIDATE_FAILED
) {
    @JvmField
    val EXCEPTION = JwtValidateException
}