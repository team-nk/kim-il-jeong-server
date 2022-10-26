package team.nk.kimiljeongserver.domain.user.presentation.dto.response

data class QueryMyInfoResponse(
    val profile: String,
    val accountId: String,
    val email: String,
)
