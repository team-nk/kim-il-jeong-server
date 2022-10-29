package team.nk.kimiljeongserver.domain.post.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.post.domain.repository.PostRepository
import team.nk.kimiljeongserver.domain.post.presentation.dto.response.PostElement
import team.nk.kimiljeongserver.domain.post.presentation.dto.response.PostListResponse
import java.time.format.DateTimeFormatter

@Service
class QueryPostService(
    private val postRepository: PostRepository,
) {

    @Transactional(readOnly = true)
    fun execute(): PostListResponse {
        val postList = postRepository.queryPost().map {
            PostElement(
                title = it.title,
                scheduleContent = it.scheduleContent,
                address = it.address,
                color = it.color,
                accountId = it.accountId,
                createTime = it.createdAt.format(DateTimeFormatter.ISO_DATE)
            )
        }

        return PostListResponse(postList)
    }
}