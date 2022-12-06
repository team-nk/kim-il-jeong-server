package team.nk.kimiljeongserver.infrastructure.feign.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object FeignBadRequestException : KimIlJeongException(GlobalErrorCode.FEIGN_BAD_REQUEST) {
    val EXCEPTION = FeignBadRequestException
}