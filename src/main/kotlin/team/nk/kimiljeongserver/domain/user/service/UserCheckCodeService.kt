package team.nk.kimiljeongserver.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.auth.domain.repository.CodeRepository
import team.nk.kimiljeongserver.global.exception.CodeNotFoundException

@Service
class UserCheckCodeService(
    private val codeRepository: CodeRepository
) {

    @Transactional
    fun execute(email:String, inputCode: String): Boolean {

        val code = codeRepository.findCodeByEmail(email) ?: throw CodeNotFoundException.EXCEPTION

        return code.value == inputCode
    }
}