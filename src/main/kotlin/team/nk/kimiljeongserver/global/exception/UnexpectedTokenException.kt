package team.nk.kimiljeongserver.global.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object UnexpectedTokenException : KimIlJeongException(
    GlobalErrorCode.UNEXPECTED_TOKEN
) {
    val EXCEPTION = UnexpectedTokenException
}