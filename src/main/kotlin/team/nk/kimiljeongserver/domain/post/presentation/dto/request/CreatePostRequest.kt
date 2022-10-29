package team.nk.kimiljeongserver.domain.post.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreatePostRequest(

    @field:Size(min = 1, max = 20, message = "title은 1~20자리 이내로 이내로 입력해주세요.")
    @field:NotBlank(message = "title은 필수 입력입니다.")
    val title: String,

    @field: NotBlank(message = "content는 필수 입력입니다.")
    val content: String,

    val scheduleId: Int
)