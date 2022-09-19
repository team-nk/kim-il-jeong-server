package team.nk.kimiljeongserver.global.error

interface ErrorProperty {
    fun status(): Int
    fun message(): String
}