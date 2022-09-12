package com.example.kimiljeongserver.domain.user.exceptions

import com.example.kimiljeongdomain.error.ErrorCode
import com.example.kimiljeongdomain.error.KimIlJeongException

class UserNotFoundException private constructor() : KimIlJeongException(ErrorCode.USER_NOT_FOUND) {

    companion object {
        @JvmField //getter, setter를 안만들어준다.
        val EXCEPTION = UserNotFoundException()
    }
}