package team.nk.kimiljeongserver.domain.user.presentation.dto.request

data class LoginUserRequest(
    val email: String,
    val password: String
)
