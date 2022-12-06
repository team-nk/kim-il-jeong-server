package team.nk.kimiljeongserver.infrastructure.feign.dto.request

data class KakaoUserInfoRequest(
    val nickname: String,
    val email: String,
    val profileImage: String
)