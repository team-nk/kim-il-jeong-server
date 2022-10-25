package team.nk.kimiljeongserver.domain.user.exception

import team.nk.kimiljeongserver.domain.user.exception.properties.UserErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object UserAlreadyExistsException : KimIlJeongException(UserErrorCode.USER_ALREADY_EXISTS) {
    val EXCEPTION = UserAlreadyExistsException
}