package team.nk.kimiljeongserver.domain.user.exception

import team.nk.kimiljeongserver.domain.user.exception.properties.UserErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object PasswordMissMatchedException : KimIlJeongException(UserErrorCode.PASSWORD_MISS_MATCHED) {
    @JvmField
    val EXCEPTION = PasswordMissMatchedException
}