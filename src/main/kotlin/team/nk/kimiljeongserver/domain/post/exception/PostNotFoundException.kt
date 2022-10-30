package team.nk.kimiljeongserver.domain.post.exception

import team.nk.kimiljeongserver.domain.post.exception.properties.PostErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object PostNotFoundException : KimIlJeongException(PostErrorCode.POST_NOT_FOUND) {
    val EXCEPTION = PostNotFoundException
}