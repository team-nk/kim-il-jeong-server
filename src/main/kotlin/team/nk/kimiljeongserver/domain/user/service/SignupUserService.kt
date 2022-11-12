package team.nk.kimiljeongserver.domain.user.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.auth.domain.repository.CodeRepository
import team.nk.kimiljeongserver.domain.user.domain.User
import team.nk.kimiljeongserver.domain.user.domain.repository.UserRepository
import team.nk.kimiljeongserver.domain.user.exception.CodeMissMatchedException
import team.nk.kimiljeongserver.domain.user.exception.PasswordMissMatchedException
import team.nk.kimiljeongserver.domain.user.exception.UserAlreadyExistsException
import team.nk.kimiljeongserver.domain.user.presentation.dto.request.SaveUserRequest
import team.nk.kimiljeongserver.global.exception.CodeNotFoundException

//import team.nk.kimiljeongserver.infrastructure.aws.email.RegisterMailService

@Service
class SignupUserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val codeRepository: CodeRepository
    //private val registerMailService: RegisterMailService
) {
    @Transactional
    fun execute(saveUserRequest: SaveUserRequest) {

        //registerMailService.send(saveUserRequest.email)

        if (saveUserRequest.password != saveUserRequest.rePassword) {
            throw PasswordMissMatchedException.EXCEPTION
        }

        if (userRepository.existsByEmail(saveUserRequest.email)) {
            throw UserAlreadyExistsException.EXCEPTION
        }

        val code = codeRepository.findCodeByEmail(saveUserRequest.email) ?: throw CodeNotFoundException.EXCEPTION

        if (code.value != saveUserRequest.code) {
            throw CodeMissMatchedException.EXCEPTION
        }

        userRepository.save(
            User(
                email = saveUserRequest.email,
                accountId = saveUserRequest.accountId,
                password = passwordEncoder.encode(saveUserRequest.password)
            )
        )
    }
}