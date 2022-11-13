package team.nk.kimiljeongserver.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.user.domain.repository.UserRepository
import team.nk.kimiljeongserver.domain.user.presentation.dto.request.CheckUserRequest

@Service
class AlreadyUserExistsService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun execute(request: CheckUserRequest): Boolean {
        return !userRepository.existsByAccountId(request.accountId)
    }
}