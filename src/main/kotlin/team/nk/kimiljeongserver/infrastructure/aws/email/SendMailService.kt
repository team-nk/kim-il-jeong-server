package team.nk.kimiljeongserver.infrastructure.aws.email

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.mail.MailProperties
import org.springframework.mail.MailException
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import team.nk.kimiljeongserver.domain.auth.domain.Code
import team.nk.kimiljeongserver.domain.auth.domain.repository.CodeRepository
import java.io.UnsupportedEncodingException
import javax.mail.MessagingException
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

@Slf4j
@Service
class SendMailService(
    private val emailRandomCodeUtil: EmailRandomCodeUtil,
    private val javaMailSender: JavaMailSender,
    private val mailProperties: MailProperties,
    private val codeRepository: CodeRepository
) {
    val code = emailRandomCodeUtil.generateCode()

    @Throws(MessagingException::class, UnsupportedEncodingException::class)
    fun createMessage(to: String): MimeMessage {
        val logger = LoggerFactory.getLogger(SendMailService::class.java)

        logger.info("보내는 대상 : " + to)
        logger.info("인증 번호 : " + code)

        val message = javaMailSender.createMimeMessage()

        message.addRecipients(MimeMessage.RecipientType.TO, to); // to 보내는 대상
        message.subject = "Kim Il Jeong 회원가입 인증 코드: "; //메일 제목

        // 메일 내용 메일의 subtype을 html로 지정하여 html문법 사용 가능
        var msg = "";
        msg += "<div class=\"\"><div class=\"aHl\"></div><div id=\":2j\" tabindex=\"-1\"></div><div id=\":2q\" class=\"ii gt\" jslog=\"20277; u014N:xr6bB; 4:W251bGwsbnVsbCxbXV0.\"><div id=\":1l\" class=\"a3s aiL \"><div class=\"adM\">\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "</div><div><div class=\"adM\">\n" +
                "\t</div><table style=\"background-color:#f2f2f2;border-collapse:collapse;border-spacing:0;font-family:'Malgun Gothic','Lucida Grande','Lucida Sans','Lucida Sans Unicode',Arial,Helvetica,Verdana,sans-serif;font-size:12px;text-align:center;width:100%\">\n" +
                "\t\t<tbody><tr><td height=\"40\" style=\"color:#999\"></td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"color:#999\">\n" +
                "\t\t\t\t<center>\n" +
                "\t\t\t\t\t<table style=\"background-color:#fff;border-collapse:collapse;border-spacing:0;;font-family:'Malgun Gothic','Lucida Grande','Lucida Sans','Lucida Sans Unicode',Arial,Helvetica,Verdana,sans-serif;font-size:12px;text-align:left;width:720px\">\n" +
                "                        <tbody>\n" +
                "                            <tr>\n" +
                "                                <img style=\"width:720px;height:360px;\" src=\"https://media.discordapp.net/attachments/1000394402486829109/1040522083496644608/unknown.png?width=1188&height=663\"/>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "\t\t\t\t\t\t\t<td style=\"color:#999\">\n" +
                "\t\t\t\t\t\t\t\t<table style=\"border-collapse:collapse;border-spacing:0;font-family:'Malgun Gothic','Lucida Grande','Lucida Sans','Lucida Sans Unicode',Arial,Helvetica,Verdana,sans-serif;font-size:12px;width:100%\">\n" +
                "\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "                                    <tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td height=\"10\" colspan=\"3\" style=\"color:#999\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td height=\"10\" colspan=\"3\" style=\"color:#999\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t</tbody></table>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td style=\"color:#999\">\n" +
                "\t\t\t\t\t\t\t\t<table style=\"border-collapse:collapse;border-spacing:0;font-family:'Malgun Gothic','Lucida Grande','Lucida Sans','Lucida Sans Unicode',Arial,Helvetica,Verdana,sans-serif;font-size:12px;width:100%\">\n" +
                "\t\t\t\t\t\t\t\t\t<tbody><tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td width=\"40\" style=\"color:#999\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"color:#999\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin:20px 0;padding:0\"><strong style=\"color:#333\">안녕하세요. <em style=\"color:#6C1FD3;font-style:normal\">Kim Il Jeong</em> 입니다.</strong></p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin:20px 0;padding:0\">" + "아래의 <span class=\"il\">인증</span><span class=\"il\">번호</span>를 복사하신 후 이메일 <span class=\"il\">인증</span><span class=\"il\">번호</span> 입력란에 입력해 주시기 바랍니다. <br><span class=\"il\"></p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div style=\"background-color:#f7f7f7;border-bottom:1px solid #e7e7e7;border-top:1px solid #e7e7e7;color:#666;font-size:16px;padding:35px;text-align:center\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span><strong style=\"color:#000;font-weight:bold;font-size:30px;\">" + code + "</strong></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin:20px 0;padding:0\"><strong style=\"color:#333\">Kim Il Jeong를 이용해 주셔서 감사합니다.</strong></p>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td width=\"40\" style=\"color:#999\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td height=\"30\" colspan=\"3\" style=\"color:#999\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t</tbody></table>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td style=\"border-top:1px solid #d9d9d9;color:#999\">\n" +
                "\t\t\t\t\t\t\t\t<table style=\"border-collapse:collapse;border-spacing:0;font-family:'Malgun Gothic','Lucida Grande','Lucida Sans','Lucida Sans Unicode',Arial,Helvetica,Verdana,sans-serif;font-size:12px;width:100%\">\n" +
                "\t\t\t\t\t\t\t\t\t<tbody><tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td height=\"40\" colspan=\"3\" style=\"color:#999\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td width=\"40\" style=\"color:#999\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td style=\"color:#999\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin:0;padding:0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t타인이 회원님의 이메일을 잘못 입력한 경우 메일이 발송될 수 있습니다. <br>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t잘못 수신된 메일이라면 thswoals3518@gmail.com에 문의해주시길 바랍니다.\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<p style=\"font-size:11px;margin:0;margin-top:10px;padding:0\">© Kim Il Jeong. All Rights Reserved.</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td width=\"40\" style=\"color:#999\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t<td height=\"40\" colspan=\"3\" style=\"color:#999\"></td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t</tbody></table>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t</tbody></table>\n" +
                "\t\t\t\t</center>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td height=\"40\" style=\"color:#999\"></td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "</div></div><div class=\"adL\">\n" +
                "</div></div></div><div id=\":2f\" class=\"ii gt\" style=\"display:none\"><div id=\":2e\" class=\"a3s aiL \"></div></div><div class=\"hi\"></div></div>";

        message.setText(msg, "utf-8", "html"); //내용, charset타입, subtype
        message.setFrom(InternetAddress(mailProperties.username, "Admin")); //보내는 사람의 메일 주소, 보내는 사람 이름

        return message;
    }

    @Throws(Exception::class)
    fun sendSimpleMessage(request: String): String {
        val message = createMessage(request)
        try {
            javaMailSender.send(message) // 메일 발송
            codeRepository.save(
                Code(
                    email = request,
                    value = code
                )
            )
        } catch (es: MailException) {
            es.printStackTrace()
            throw IllegalArgumentException()
        }
        return code// 메일로 보냈던 인증 코드를 서버로 리턴
    }
}