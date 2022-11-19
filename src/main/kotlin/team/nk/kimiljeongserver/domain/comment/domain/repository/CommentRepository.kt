package team.nk.kimiljeongserver.domain.comment.domain.repository

import org.springframework.data.repository.CrudRepository
import team.nk.kimiljeongserver.domain.comment.domain.Comment
import team.nk.kimiljeongserver.domain.post.domain.Post

interface CommentRepository : CrudRepository<Comment, Int>, CustomCommentRepository {
    fun countAllByPost(post: Post): Int
}