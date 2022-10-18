package team.nk.kimiljeongserver.global.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object ExpiredTokenException : KimIlJeongException(
    GlobalErrorCode.JWT_EXPIRED
) {
    @JvmField
    val EXCEPTION = ExpiredTokenException
}
