package team.nk.kimiljeongserver.infrastructure.aws.image.facade

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.multipart.MultipartFile
import team.nk.kimiljeongserver.infrastructure.aws.image.exception.ImageNotFoundException
import team.nk.kimiljeongserver.infrastructure.aws.image.exception.InvalidImageExtensionFormatException
import java.io.IOException
import java.util.*

class ImageFacade(
    private val amazonS3Client: AmazonS3Client,

    @Value("\${cloud.aws.s3.bucket}")
    private val bucket: String
) {
    fun upload(multipartFile: MultipartFile): String {
        val extension: String = getExtension(multipartFile)
        val imageUrl = "${UUID.randomUUID()} $extension"

        val objectMetadata = ObjectMetadata()
        objectMetadata.contentLength = multipartFile.size
        objectMetadata.contentType = multipartFile.contentType

        try {
            amazonS3Client.putObject(
                PutObjectRequest(bucket, imageUrl, multipartFile.inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead)
            )
        } catch (e: IOException) {
            throw ImageNotFoundException.EXCEPTION
        }

        return amazonS3Client.getUrl(bucket, imageUrl).toString()
    }

    private fun getExtension(multipartFile: MultipartFile): String {
        if (multipartFile.isEmpty || multipartFile.originalFilename == null) {
            throw ImageNotFoundException.EXCEPTION
        }

        val originalName: String? = multipartFile.originalFilename
        val extension: String? = originalName?.let { originalName.substring(it.lastIndexOf(".")) }

        if (!(extension == ".jpg" || extension == ".jpeg" || extension == ".png" || extension == ".heic")) {
            throw InvalidImageExtensionFormatException.EXCEPTION
        }

        return extension
    }
}