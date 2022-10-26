package team.nk.kimiljeongserver.domain.schedule.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import team.nk.kimiljeongserver.domain.schedule.domain.Schedule
import team.nk.kimiljeongserver.domain.user.domain.User

@Repository
interface ScheduleRepository : CrudRepository<Schedule, Int> {

    fun findScheduleById(scheduleId: Int): Schedule?

    fun findAllByUserOrderByStartTimeAsc(user: User): List<Schedule>?

    fun findAllByUserOrderByStartTimeDesc(user: User): List<Schedule>?

}