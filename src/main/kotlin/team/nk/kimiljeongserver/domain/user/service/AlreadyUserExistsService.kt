package team.nk.kimiljeongserver.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.user.domain.repository.UserRepository
import team.nk.kimiljeongserver.domain.user.presentation.dto.response.QueryBooleanResponse

@Service
class AlreadyUserExistsService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun execute(accountId: String): QueryBooleanResponse {
        return QueryBooleanResponse(!userRepository.existsByAccountId(accountId))
    }
}