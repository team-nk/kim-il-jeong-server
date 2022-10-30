package team.nk.kimiljeongserver.domain.post.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.post.domain.Post
import team.nk.kimiljeongserver.domain.post.domain.repository.PostRepository
import team.nk.kimiljeongserver.domain.post.presentation.dto.request.CreatePostRequest
import team.nk.kimiljeongserver.domain.schedule.facade.ScheduleFacade
import team.nk.kimiljeongserver.domain.user.facade.UserFacade

@Service
class CreatePostService(
    private val userFacade: UserFacade,
    private val scheduleFacade: ScheduleFacade,
    private val postRepository: PostRepository,
) {

    @Transactional
    fun execute(request: CreatePostRequest) {
        val user = userFacade.getCurrentUser()
        val schedule = scheduleFacade.getScheduleById(request.scheduleId)

        postRepository.save(
            Post(
                title = request.title,
                content = request.content,
                user = user,
                schedule = schedule
            )
        )
    }
}