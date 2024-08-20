package com.hana.aiforkid.parent.dto.request

import com.hana.aiforkid.parent.domain.Gender
import java.time.LocalDateTime

data class AddChildRequest(
    val name: String,
    val birthDate: LocalDateTime,
    val gender: Gender,
    val weight: Double,
    val height: Int
)
