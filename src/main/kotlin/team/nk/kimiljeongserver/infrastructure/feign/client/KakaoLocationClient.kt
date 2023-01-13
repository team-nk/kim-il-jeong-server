package team.nk.kimiljeongserver.infrastructure.feign.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import team.nk.kimiljeongserver.infrastructure.feign.dto.response.KakaoLocationResponse

@FeignClient(name = "kakaoFeignClient", url = "https://dapi.kakao.com//v2/local/search/address.json")
interface KakaoLocationClient {

    @PostMapping
    fun getLocation(
        @RequestParam("query") query: String, @RequestHeader("Authorization") authorization: String
    ): KakaoLocationResponse
}