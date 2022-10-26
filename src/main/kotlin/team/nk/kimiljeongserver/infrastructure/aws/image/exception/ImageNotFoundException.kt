package team.nk.kimiljeongserver.infrastructure.aws.image.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object ImageNotFoundException : KimIlJeongException(GlobalErrorCode.IMAGE_NOT_FOUND) {
    val EXCEPTION = ImageNotFoundException
}