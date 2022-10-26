package team.nk.kimiljeongserver.domain.image.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import team.nk.kimiljeongserver.domain.image.presentation.dto.response.ImageResponse
import team.nk.kimiljeongserver.domain.image.service.ImageService

@Tag(name = "이미지", description = "이미지 관련 API입니다.")
@RequestMapping("/image")
@RestController
class ImageController(
    private val imageService: ImageService
) {

    @Operation(summary = "이미지 업로드")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun imageUpload(@RequestParam image: MultipartFile): ImageResponse {
        return imageService.imageUpload(image)
    }
}