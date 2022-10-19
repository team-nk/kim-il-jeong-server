package team.nk.kimiljeongserver.domain.user.facade

import org.springframework.stereotype.Component
import team.nk.kimiljeongserver.domain.user.domain.User
import team.nk.kimiljeongserver.domain.user.domain.repository.UserRepository
import team.nk.kimiljeongserver.domain.user.exception.UserNotFoundException

@Component
class UserFacade(
    private val userRepository: UserRepository
) {

    fun getUserByEmail(email: String): User {
        return userRepository.findByEmail(email) ?: throw UserNotFoundException.EXCEPTION
    }
}
