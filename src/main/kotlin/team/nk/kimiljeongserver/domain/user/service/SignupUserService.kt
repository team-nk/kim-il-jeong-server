package team.nk.kimiljeongserver.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.user.domain.User
import team.nk.kimiljeongserver.domain.user.domain.repository.UserRepository
import team.nk.kimiljeongserver.domain.user.exception.PasswordMissMatchedException
import team.nk.kimiljeongserver.domain.user.presentation.dto.request.SaveUserRequest
//import team.nk.kimiljeongserver.infrastructure.aws.email.RegisterMailService

@Service
class SignupUserService(
    private val userRepository: UserRepository,
    //private val registerMailService: RegisterMailService
) {
    @Transactional
    fun execute(saveUserRequest: SaveUserRequest) {

        //registerMailService.send(saveUserRequest.email)

        if (saveUserRequest.password != saveUserRequest.rePassword) {
            throw PasswordMissMatchedException.EXCEPTION
        }

        userRepository.save(
            User(
                email = saveUserRequest.email,
                accountId = saveUserRequest.accountId,
                password = saveUserRequest.password
            )
        )
    }
}