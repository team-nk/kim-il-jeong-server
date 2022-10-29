package team.nk.kimiljeongserver.domain.post.domain.repository

import team.nk.kimiljeongserver.domain.post.domain.repository.vo.PostVO

interface CustomPostRepository {
    fun queryPost(): List<PostVO>
}