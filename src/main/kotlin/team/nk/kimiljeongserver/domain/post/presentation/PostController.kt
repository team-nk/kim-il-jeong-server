package team.nk.kimiljeongserver.domain.post.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import team.nk.kimiljeongserver.domain.post.presentation.dto.request.CreatePostRequest
import team.nk.kimiljeongserver.domain.post.presentation.dto.response.PostDetailsResponse
import team.nk.kimiljeongserver.domain.post.presentation.dto.response.PostListResponse
import team.nk.kimiljeongserver.domain.post.presentation.dto.response.UserListResponse
import team.nk.kimiljeongserver.domain.post.service.CreatePostService
import team.nk.kimiljeongserver.domain.post.service.QueryPostDetailsService
import team.nk.kimiljeongserver.domain.post.service.QueryPostService
import team.nk.kimiljeongserver.domain.post.service.QueryUserBirthdayService
import javax.validation.Valid

@Tag(name = "게시글", description = "게시글 관련 API입니다.")
@RequestMapping("/post")
@RestController
class PostController(
    private val createPostService: CreatePostService,
    private val queryPostService: QueryPostService,
    private val queryPostDetailsService: QueryPostDetailsService,
    private val queryUserBirthdayService: QueryUserBirthdayService
) {

    @Operation(summary = "게시글 생성")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createPost(@Valid @RequestBody request: CreatePostRequest) {
        createPostService.execute(request)
    }

    @Operation(summary = "게시글 조회")
    @GetMapping
    fun queryPost(): PostListResponse {
        return queryPostService.execute()
    }

    @Operation(summary = "게시글 상세 조회")
    @GetMapping("/{post-id}")
    fun queryDetailsPost(@PathVariable("post-id")postId: Int): PostDetailsResponse {
        return queryPostDetailsService.execute(postId)
    }

    @Operation(summary = "생일 리시트 조회")
    @GetMapping("/birthday")
    fun queryBirthdayUserList(): UserListResponse {
        return queryUserBirthdayService.execute()
    }
}