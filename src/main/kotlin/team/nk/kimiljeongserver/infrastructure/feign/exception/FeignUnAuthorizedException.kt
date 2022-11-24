package team.nk.kimiljeongserver.infrastructure.feign.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object FeignUnAuthorizedException : KimIlJeongException(GlobalErrorCode.FEIGN_UN_AUTHORIZED){
    val EXCEPTION = FeignUnAuthorizedException
}