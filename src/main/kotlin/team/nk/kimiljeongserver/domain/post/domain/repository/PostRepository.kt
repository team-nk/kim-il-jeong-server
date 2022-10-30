package team.nk.kimiljeongserver.domain.post.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import team.nk.kimiljeongserver.domain.post.domain.Post

@Repository
interface PostRepository : CrudRepository<Post, Int>, CustomPostRepository {
}