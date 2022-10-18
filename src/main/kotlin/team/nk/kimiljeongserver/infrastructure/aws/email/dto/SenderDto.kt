package team.nk.kimiljeongserver.infrastructure.aws.email.dto

import com.amazonaws.services.simpleemail.model.Destination
import com.amazonaws.services.simpleemail.model.SendTemplatedEmailRequest

class SenderDto(
    private val to: String,
    private val source: String,
    private val subject: String,
    private val code: String
) {

    fun sendTemplatedEmailRequest(): SendTemplatedEmailRequest? {
        val destination = Destination().withToAddresses(to)
        return SendTemplatedEmailRequest()
            .withDestination(destination)
            .withSource(source)
            .withTemplate(subject)
            .withTemplateData(code)
    }
}