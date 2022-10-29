package team.nk.kimiljeongserver.domain.post.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.post.presentation.dto.response.UserBirthdayElement
import team.nk.kimiljeongserver.domain.post.presentation.dto.response.UserListResponse
import team.nk.kimiljeongserver.domain.user.domain.repository.UserRepository
import java.time.LocalDate

@Service
class QueryUserBirthdayService(
    private val userRepository: UserRepository
) {

    @Transactional(readOnly = true)
    fun execute(): UserListResponse {
        val userList = userRepository.findAll()
            .filter {
                isBirthday(it.birthday)
            }
            .map {
                UserBirthdayElement(
                    accountId = it.accountId,
                    age = getAge(it.birthday),
                    birthday = it.birthday
                )
            }

        return UserListResponse(userList)
    }

    private fun isBirthday(birthday: LocalDate): Boolean {
        val month = LocalDate.now().month
        val day = LocalDate.now().dayOfMonth

        return month == birthday.month && day == birthday.dayOfMonth
    }

    private fun getAge(birthday: LocalDate): Int {
        val date = LocalDate.now().year
        return date - birthday.year + 1
    }
}