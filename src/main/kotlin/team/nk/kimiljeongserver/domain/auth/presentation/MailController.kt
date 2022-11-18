package team.nk.kimiljeongserver.domain.auth.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import team.nk.kimiljeongserver.infrastructure.aws.email.SendMailService

@Tag(name = "메일", description = "메일 관련 API입니다.")
@RequestMapping("/mail")
@RestController
class MailController(
    private val sendMailService: SendMailService
) {

    @Operation(summary = "메일 전송")
    @GetMapping
    fun sendMail(@RequestParam("email") email: String): String {
        return sendMailService.sendSimpleMessage(email)
    }
}