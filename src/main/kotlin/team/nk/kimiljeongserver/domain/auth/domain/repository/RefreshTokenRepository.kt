package team.nk.kimiljeongserver.domain.auth.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import team.nk.kimiljeongserver.domain.auth.domain.RefreshToken

@Repository
interface RefreshTokenRepository : CrudRepository<RefreshToken, String>