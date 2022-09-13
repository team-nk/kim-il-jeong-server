package com.example.kimiljeongserver.domain.user.domain.repositroy

import com.example.kimiljeongserver.domain.user.domain.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<UserEntity, UUID> {
    fun findByAccountId(accountId: String): UserEntity?
}
