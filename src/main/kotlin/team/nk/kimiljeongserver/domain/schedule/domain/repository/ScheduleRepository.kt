package team.nk.kimiljeongserver.domain.schedule.domain.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import team.nk.kimiljeongserver.domain.schedule.domain.Schedule
import team.nk.kimiljeongserver.domain.user.domain.User
import java.math.BigDecimal

@Repository
interface ScheduleRepository : CrudRepository<Schedule, Int> {

    fun findScheduleById(scheduleId: Int): Schedule?

    fun findAllByUserOrderByStartTimeAsc(user: User): List<Schedule>?

    fun findAllByUserOrderByStartTimeDesc(user: User): List<Schedule>?

/*    @Query(
        value = "SELECT *, (6371 * acos(cos(radians(:x)) * cos(radians(s.latitude)) * cos(radians(s.longitude) - radians(:y)) + sin(radians(:x)) * sin(radians(s.latitude)))) AS distance FROM tbl_schedule AS s HAVING distance <= :d ORDER BY distance;",
        nativeQuery = true
    )
    fun findAllSchedule(
        @Param(value = "x") x: BigDecimal, @Param(value = "y") y: BigDecimal, @Param(value = "d") d: BigDecimal
    ): List<Schedule>*/
}