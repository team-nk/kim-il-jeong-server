package team.nk.kimiljeongserver.infrastructure.feign.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object FeignExpiredTokenException : KimIlJeongException(GlobalErrorCode.FEIGN_EXPIRED_TOKEN) {
    val EXCEPTION = FeignExpiredTokenException
}