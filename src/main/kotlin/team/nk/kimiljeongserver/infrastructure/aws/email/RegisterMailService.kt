package team.nk.kimiljeongserver.infrastructure.aws.email

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync
import com.amazonaws.services.simpleemail.model.MessageRejectedException
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import team.nk.kimiljeongserver.global.exception.MessageIsRejectedException
import team.nk.kimiljeongserver.infrastructure.aws.email.dto.SenderDto


@Slf4j
@Service
class RegisterMailService(
    val awsSESProperties: AwsSESProperties,
    val emailRandomCodeUtil: EmailRandomCodeUtil,
    val amazonSimpleEmailServiceAsync: AmazonSimpleEmailServiceAsync
) {

    fun send(to: String) {
        val amazonMailDto = SenderDto(
            to = to,
            source = awsSESProperties.sesSource,
            subject = "이메일 인증 코드",
            code = emailRandomCodeUtil.generateCode().toString()
        )

        try {
            amazonSimpleEmailServiceAsync.sendTemplatedEmailAsync(amazonMailDto.sendTemplatedEmailRequest())
        } catch (e: MessageRejectedException) {
            throw MessageIsRejectedException.EXCEPTION
        }
    }
}