package team.nk.kimiljeongserver.global.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object RefreshTokenNotFoundException : KimIlJeongException(
    GlobalErrorCode.REFRESH_TOKEN_NOT_FOUND
) {
    val EXCEPTION = RefreshTokenNotFoundException
}