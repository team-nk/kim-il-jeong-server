package team.nk.kimiljeongserver.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.user.domain.repository.UserRepository
import team.nk.kimiljeongserver.domain.user.facade.UserFacade
import team.nk.kimiljeongserver.domain.user.presentation.dto.request.ModifyUserInfoRequest

@Service
class ModifyUserInfoService(
    private val userFacade: UserFacade,
) {

    @Transactional
    fun execute(request: ModifyUserInfoRequest) {
        val user = userFacade.getCurrentUser()

        user.modifyUserInfo(request.email, request.accountId, request.profile)
    }
}