package team.nk.kimiljeongserver.domain.comment.domain.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import team.nk.kimiljeongserver.domain.comment.domain.QComment.comment
import team.nk.kimiljeongserver.domain.comment.domain.repository.vo.CommentVO
import team.nk.kimiljeongserver.domain.comment.domain.repository.vo.QCommentVO
import team.nk.kimiljeongserver.domain.post.domain.QPost.post
import team.nk.kimiljeongserver.domain.user.domain.QUser.user

class CustomCommentRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CustomCommentRepository {
    override fun queryComment(postId: Int): List<CommentVO> {
        return jpaQueryFactory.select(
            QCommentVO(
                comment.content,
                user.accountId,
                user.profile,
                comment.createdAt
            )
        )
            .from(comment)
            .leftJoin(comment.user, user)
            .leftJoin(comment.post, post)
            .where(post.id.eq(postId))
            .orderBy(comment.createdAt.desc())
            .fetch().toList()
    }
}