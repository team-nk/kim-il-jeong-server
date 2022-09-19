package team.nk.kimiljeongserver.global.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object InternalServerErrorException : KimIlJeongException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR
) {

    @JvmField
    val EXCEPTION = InternalServerErrorException
}