package team.nk.kimiljeongserver.domain.post.domain.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import team.nk.kimiljeongserver.domain.post.domain.repository.vo.PostVO
import team.nk.kimiljeongserver.domain.post.domain.repository.vo.QPostVO
import team.nk.kimiljeongserver.domain.user.domain.QUser.user
import team.nk.kimiljeongserver.domain.schedule.domain.QSchedule.schedule
import team.nk.kimiljeongserver.domain.post.domain.QPost.post

class CustomPostRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CustomPostRepository {

    override fun queryPost(): List<PostVO> {
        return jpaQueryFactory.select(
            QPostVO(
                post.title,
                schedule.content,
                schedule.address,
                schedule.color,
                user.accountId,
                post.createdAt
            )
        )
            .from(post)
            .leftJoin(post.schedule, schedule)
            .leftJoin(post.user, user)
            .orderBy(post.createdAt.desc())
            .fetch().toList()
    }
}