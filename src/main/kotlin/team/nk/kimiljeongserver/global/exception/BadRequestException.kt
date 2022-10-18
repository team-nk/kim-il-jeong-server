package team.nk.kimiljeongserver.global.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object BadRequestException : KimIlJeongException(
    GlobalErrorCode.BAD_REQUEST
) {
    val EXCEPTION = BadRequestException
}