package team.nk.kimiljeongserver.global.error.exception

import team.nk.kimiljeongserver.global.error.ErrorProperty

abstract class KimIlJeongException(
    val errorProperty: ErrorProperty
) : RuntimeException() {

    override fun fillInStackTrace() = this
}