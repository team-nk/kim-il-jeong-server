package team.nk.kimiljeongserver.domain.image.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import team.nk.kimiljeongserver.domain.image.presentation.dto.response.ImageResponse
import team.nk.kimiljeongserver.infrastructure.aws.image.facade.ImageFacade

@Service
class ImageService(
    private val imageFacade: ImageFacade
) {

    @Transactional
    fun imageUpload(image: MultipartFile): ImageResponse {
        val imageUrl = imageFacade.upload(image)

        return ImageResponse(imageUrl)
    }
}