package team.nk.kimiljeongserver.domain.post.facade

import org.springframework.stereotype.Component
import team.nk.kimiljeongserver.domain.post.domain.Post
import team.nk.kimiljeongserver.domain.post.domain.repository.PostRepository
import team.nk.kimiljeongserver.domain.post.exception.PostNotFoundException

@Component
class PostFacade(
    private val postRepository: PostRepository
) {

    fun getPostById(postId: Int): Post {
        return postRepository.findPostById(postId) ?: throw PostNotFoundException.EXCEPTION
    }
}