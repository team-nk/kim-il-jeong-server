package team.nk.kimiljeongserver.infrastructure.aws.image.exception

import team.nk.kimiljeongserver.global.error.GlobalErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object InvalidImageExtensionFormatException : KimIlJeongException(GlobalErrorCode.INVALID_IMAGE_EXTENSION_FORMAT) {
    val EXCEPTION = InvalidImageExtensionFormatException;
}