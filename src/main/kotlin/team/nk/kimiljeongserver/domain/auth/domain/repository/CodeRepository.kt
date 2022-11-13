package team.nk.kimiljeongserver.domain.auth.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import team.nk.kimiljeongserver.domain.auth.domain.Code

@Repository
interface CodeRepository : CrudRepository<Code, String> {
    fun findCodeByEmail(email: String): Code?
}