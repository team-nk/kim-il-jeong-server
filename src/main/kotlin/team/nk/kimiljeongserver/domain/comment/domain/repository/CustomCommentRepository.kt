package team.nk.kimiljeongserver.domain.comment.domain.repository

import team.nk.kimiljeongserver.domain.comment.domain.repository.vo.CommentVO

interface CustomCommentRepository {
    fun queryComment(postId: Int): List<CommentVO>
}