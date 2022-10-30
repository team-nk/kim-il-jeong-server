package team.nk.kimiljeongserver.domain.comment.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.comment.domain.Comment
import team.nk.kimiljeongserver.domain.comment.domain.repository.CommentRepository
import team.nk.kimiljeongserver.domain.comment.presentation.dto.request.CreateCommentRequest
import team.nk.kimiljeongserver.domain.post.facade.PostFacade
import team.nk.kimiljeongserver.domain.user.facade.UserFacade

@Service
class CreateCommentService(
    private val userFacade: UserFacade,
    private val postFacade: PostFacade,
    private val commentRepository: CommentRepository
) {

    @Transactional
    fun execute(postId: Int, request: CreateCommentRequest) {
        val user = userFacade.getCurrentUser()
        val post = postFacade.getPostById(postId)

        commentRepository.save(
            Comment(
                content = request.content,
                user = user,
                post = post
            )
        )
    }
}