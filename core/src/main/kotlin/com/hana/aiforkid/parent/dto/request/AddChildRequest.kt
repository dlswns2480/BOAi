package com.hana.aiforkid.parent.dto.request

import com.hana.aiforkid.parent.domain.Gender
import java.time.LocalDate

data class AddChildRequest(
    val name: String,
    val birthDate: LocalDate,
    val gender: Gender,
    val weight: Double,
    val height: Int
)
