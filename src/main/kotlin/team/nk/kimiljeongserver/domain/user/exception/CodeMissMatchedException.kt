package team.nk.kimiljeongserver.domain.user.exception

import team.nk.kimiljeongserver.domain.user.exception.properties.UserErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object CodeMissMatchedException : KimIlJeongException(UserErrorCode.CODE_MISS_MATCHED) {
    val EXCEPTION = CodeMissMatchedException
}