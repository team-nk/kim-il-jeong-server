package team.nk.kimiljeongserver.global.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object MessageIsRejectedException : KimIlJeongException(
    GlobalErrorCode.MESSAGE_IS_REJECTED
) {
    @JvmField
    val EXCEPTION = MessageIsRejectedException
}