package team.nk.kimiljeongserver.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.user.facade.UserFacade
import team.nk.kimiljeongserver.domain.user.presentation.dto.request.ModifyBirthdayRequest

@Service
class ModifyBirthdayService(
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(modifyBirthdayRequest: ModifyBirthdayRequest) {
        val user = userFacade.getCurrentUser()

        user.modifyBirthday(modifyBirthdayRequest.birthday)
    }
}