package team.nk.kimiljeongserver.domain.post.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.comment.domain.repository.CommentRepository
import team.nk.kimiljeongserver.domain.post.facade.PostFacade
import team.nk.kimiljeongserver.domain.post.presentation.dto.response.PostDetailsResponse
import team.nk.kimiljeongserver.domain.user.facade.UserFacade
import java.time.format.DateTimeFormatter

@Service
class QueryPostDetailsService(
    private val commentRepository: CommentRepository,
    private val userFacade: UserFacade,
    private val postFacade: PostFacade,
) {

    @Transactional(readOnly = true)
    fun execute(postId: Int): PostDetailsResponse {
        val currentUser = userFacade.getCurrentUser()
        val post = postFacade.getPostById(postId)
        val commentCount = commentRepository.countAllByPost(post)
        val isMine = post.user == currentUser

        return PostDetailsResponse(
            title = post.title,
            content = post.content,
            scheduleContent = post.schedule.content,
            address = post.schedule.address,
            color = post.schedule.color,
            commentCount = commentCount,
            isMine = isMine,
            accountId = post.user.accountId,
            createTime = post.createdAt.format(DateTimeFormatter.ISO_DATE)
        )
    }
}