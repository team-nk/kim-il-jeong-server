package team.nk.kimiljeongserver.domain.comment.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.comment.domain.repository.CommentRepository
import team.nk.kimiljeongserver.domain.comment.presentation.dto.response.CommentElement
import team.nk.kimiljeongserver.domain.comment.presentation.dto.response.CommentListResponse

@Service
class QueryCommentService(
    private val commentRepository: CommentRepository
) {

    @Transactional(readOnly = true)
    fun execute(postId: Int): CommentListResponse {
        val commentList = commentRepository.queryComment(postId)
            .map {
            CommentElement(
                content = it.content,
                accountId = it.accountId,
                profile = it.profile,
                createTime = it.createTime
            )
        }

        return CommentListResponse(commentList)
    }
}