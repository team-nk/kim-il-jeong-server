package team.nk.kimiljeongserver.domain.schedule.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import team.nk.kimiljeongserver.domain.schedule.domain.Schedule

@Repository
interface ScheduleRepository : CrudRepository<Schedule, Int> {
}