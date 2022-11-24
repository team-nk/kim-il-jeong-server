package team.nk.kimiljeongserver.infrastructure.feign.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import team.nk.kimiljeongserver.infrastructure.feign.dto.response.GoogleUserInfoResponse

@FeignClient(name = "goolgeFeignClient", url = "https://oauth2.googleapis.com/tokeninfo")
interface GoogleTokenClient {

    @GetMapping
    fun checkIdToken(
        @RequestParam("id_token") idToken: String,
    ): GoogleUserInfoResponse
}