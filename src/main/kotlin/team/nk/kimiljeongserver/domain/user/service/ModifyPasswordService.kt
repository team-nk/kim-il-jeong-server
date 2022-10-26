package team.nk.kimiljeongserver.domain.user.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.user.exception.PasswordMissMatchedException
import team.nk.kimiljeongserver.domain.user.facade.UserFacade
import team.nk.kimiljeongserver.domain.user.presentation.dto.request.ModifyPasswordRequest

@Service
class ModifyPasswordService(
    private val userFacade: UserFacade,
    private val passwordEncode: PasswordEncoder
) {

    @Transactional
    fun execute(modifyPasswordRequest: ModifyPasswordRequest) {
        val user = userFacade.getCurrentUser()

        if (!passwordEncode.matches(modifyPasswordRequest.nowPassword, user.password) ||
            modifyPasswordRequest.newPassword != modifyPasswordRequest.new2Password
        ) {
            throw PasswordMissMatchedException.EXCEPTION
        }

        user.modifyPassword(passwordEncode.encode(modifyPasswordRequest.newPassword))
    }
}