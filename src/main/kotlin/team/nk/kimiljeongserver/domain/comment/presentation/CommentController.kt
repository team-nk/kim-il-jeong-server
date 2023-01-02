package team.nk.kimiljeongserver.domain.comment.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import team.nk.kimiljeongserver.domain.comment.presentation.dto.request.CreateCommentRequest
import team.nk.kimiljeongserver.domain.comment.presentation.dto.response.CommentListResponse
import team.nk.kimiljeongserver.domain.comment.service.CreateCommentService
import team.nk.kimiljeongserver.domain.comment.service.QueryCommentService
import javax.validation.Valid

@Tag(name = "댓글", description = "댓글 관련 API입니다.")
@RequestMapping("/comment")
@RestController
class CommentController(
    private val createCommentService: CreateCommentService,
    private val queryCommentService: QueryCommentService
) {

    @Operation(summary = "댓글 작성")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{post-id}")
    fun createComment(@PathVariable("post-id") postId: Int, @Valid @RequestBody request: CreateCommentRequest) {
        createCommentService.execute(postId, request)
    }

    @Operation(summary = "댓글 전체 조회")
    @GetMapping("/{post-id}")
    fun queryComment(@PathVariable("post-id") postId: Int): CommentListResponse {
        return queryCommentService.execute(postId)
    }
}