package team.nk.kimiljeongserver.infrastructure.feign.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object FeignForbiddenException : KimIlJeongException(GlobalErrorCode.FEIGN_FORBIDDEN) {
    val EXCEPTION = FeignForbiddenException
}