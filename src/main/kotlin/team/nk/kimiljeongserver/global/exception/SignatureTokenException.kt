package team.nk.kimiljeongserver.global.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object SignatureTokenException : KimIlJeongException(
    GlobalErrorCode.JWT_SIGNATURE
) {
    @JvmField
    val EXCEPTION = SignatureTokenException
}