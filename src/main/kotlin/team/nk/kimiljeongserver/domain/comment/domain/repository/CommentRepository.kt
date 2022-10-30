package team.nk.kimiljeongserver.domain.comment.domain.repository

import org.springframework.data.repository.CrudRepository
import team.nk.kimiljeongserver.domain.comment.domain.Comment

interface CommentRepository : CrudRepository<Comment, Int>, CustomCommentRepository {
}