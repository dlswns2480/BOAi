package com.hana.aiforkid.parent.domain

import com.hana.aiforkid.child.exception.ChildErrorCode
import com.hana.aiforkid.common.exception.ClientValidationException

enum class Gender(
    val description: String
) {
    MALE("남자"), FEMALE("여자");

    companion object {
        fun of(input: String): Gender {
            return Gender.entries
                .firstOrNull { it.description == input }
                ?: throw ClientValidationException(ChildErrorCode.INVALID_GENDER)
        }
    }
}