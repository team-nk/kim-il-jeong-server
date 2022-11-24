package team.nk.kimiljeongserver.infrastructure.feign.dto.response

data class GoogleUserInfoResponse(
    val name: String,
    val email: String,
    val picture: String
)