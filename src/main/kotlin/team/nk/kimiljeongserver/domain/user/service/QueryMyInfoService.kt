package team.nk.kimiljeongserver.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.user.facade.UserFacade
import team.nk.kimiljeongserver.domain.user.presentation.dto.response.QueryMyInfoResponse

@Service
class QueryMyInfoService(
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(): QueryMyInfoResponse {
        val user = userFacade.getCurrentUser()

        return QueryMyInfoResponse(
            profile = user.profile,
            accountId = user.accountId,
            email = user.email
        )
    }
}