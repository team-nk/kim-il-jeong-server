package team.nk.kimiljeongserver.domain.auth.domain.repository

import org.springframework.data.repository.CrudRepository
import team.nk.kimiljeongserver.domain.auth.domain.RefreshToken

interface RefreshTokenRepository : CrudRepository<RefreshToken, String>