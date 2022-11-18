package team.nk.kimiljeongserver.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.user.domain.repository.UserRepository

@Service
class AlreadyUserExistsService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun execute(accountId: String): Boolean {
        return !userRepository.existsByAccountId(accountId)
    }
}