package team.nk.kimiljeongserver.domain.user.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import team.nk.kimiljeongserver.domain.user.domain.User

@Repository
interface UserRepository : CrudRepository<User, Int> {

    fun findByEmail(email: String): User?

    fun existsByAccountId(accountId: String): Boolean

    fun existsByEmail(email: String): Boolean
}