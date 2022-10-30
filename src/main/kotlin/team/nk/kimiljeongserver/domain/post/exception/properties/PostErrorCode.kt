package team.nk.kimiljeongserver.domain.post.exception.properties

import org.springframework.http.HttpStatus
import team.nk.kimiljeongserver.global.error.ErrorProperty

enum class PostErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "Post Not Found");

    override fun status() = status.value()
    override fun message() = message
}