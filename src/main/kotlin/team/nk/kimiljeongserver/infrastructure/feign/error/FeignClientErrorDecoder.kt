package team.nk.kimiljeongserver.infrastructure.feign.error

import feign.FeignException.FeignClientException
import feign.Response
import feign.codec.ErrorDecoder
import team.nk.kimiljeongserver.infrastructure.feign.exception.FeignBadRequestException
import team.nk.kimiljeongserver.infrastructure.feign.exception.FeignExpiredTokenException
import team.nk.kimiljeongserver.infrastructure.feign.exception.FeignForbiddenException
import team.nk.kimiljeongserver.infrastructure.feign.exception.FeignUnAuthorizedException
import java.lang.Exception

class FeignClientErrorDecoder : ErrorDecoder {
    override fun decode(methodKey: String, response: Response): Exception {
        if(response.status() >= 400) {
            when(response.status()) {
                401 -> throw FeignUnAuthorizedException.EXCEPTION
                403 -> throw FeignForbiddenException.EXCEPTION
                419 -> throw FeignExpiredTokenException.EXCEPTION
                else -> throw FeignBadRequestException.EXCEPTION
            }
        }
        return FeignClientException.errorStatus(methodKey, response)
    }
}