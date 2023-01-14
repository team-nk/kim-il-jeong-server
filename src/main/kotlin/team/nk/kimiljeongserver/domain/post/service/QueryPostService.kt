package team.nk.kimiljeongserver.domain.post.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.comment.domain.repository.CommentRepository
import team.nk.kimiljeongserver.domain.post.domain.repository.PostRepository
import team.nk.kimiljeongserver.domain.post.presentation.dto.response.PostElement
import team.nk.kimiljeongserver.domain.post.presentation.dto.response.PostListResponse
import team.nk.kimiljeongserver.domain.user.facade.UserFacade
import java.time.format.DateTimeFormatter

@Service
class QueryPostService(
    private val postRepository: PostRepository,
    private val userFacade: UserFacade
) {

    @Transactional(readOnly = true)
    fun execute(): PostListResponse {
        val currentUser = userFacade.getCurrentUser()
        val postList = postRepository.queryPost().map {
            val isMine = it.user == currentUser
            PostElement(
                id = it.id,
                title = it.title,
                scheduleContent = it.scheduleContent,
                address = it.address,
                color = it.color,
                isMine = isMine,
                accountId = it.accountId,
                createTime = it.createdAt.format(DateTimeFormatter.ISO_DATE)
            )
        }

        return PostListResponse(postList)
    }
}