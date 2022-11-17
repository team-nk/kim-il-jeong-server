package team.nk.kimiljeongserver.domain.user.presentation.dto.request

data class CheckCodeRequest(
    val email: String,
    val code: String
)