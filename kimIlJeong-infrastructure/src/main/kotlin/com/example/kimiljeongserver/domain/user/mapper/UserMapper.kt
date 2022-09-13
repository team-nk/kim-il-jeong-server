package com.example.kimiljeongserver.domain.user.mapper

import com.example.kimiljeongdomain.user.User
import com.example.kimiljeongserver.domain.user.domain.UserEntity
import org.mapstruct.Mapper

@Mapper
interface UserMapper {
    fun userDomainToEntity(user: User): UserEntity
}
