package team.nk.kimiljeongserver.domain.user.exception

import team.nk.kimiljeongserver.domain.user.exception.properties.UserErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object UserNotFoundException : KimIlJeongException(UserErrorCode.USER_NOT_FOUND) {
    val EXCEPTION = UserNotFoundException
}