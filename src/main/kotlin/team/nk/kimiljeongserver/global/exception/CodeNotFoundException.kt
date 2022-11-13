package team.nk.kimiljeongserver.global.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object CodeNotFoundException : KimIlJeongException(GlobalErrorCode.CODE_NOT_FOUND) {
    val EXCEPTION = CodeNotFoundException
}
