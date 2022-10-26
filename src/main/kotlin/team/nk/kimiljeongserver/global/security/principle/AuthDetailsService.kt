package team.nk.kimiljeongserver.global.security.principle

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import team.nk.kimiljeongserver.domain.user.facade.UserFacade

@Component
class AuthDetailsService(
    private val userFacade: UserFacade
) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user = userFacade.getUserByEmail(email)
        return AuthDetails(user = user)
    }
}
