package team.nk.kimiljeongserver.domain.user.presentation.dto.request

data class ModifyPasswordRequest(
    val nowPassword: String,
    val newPassword: String,
    val new2Password: String
)