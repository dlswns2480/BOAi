package com.hana.aiforkid.parent.dto.respoonse

data class AddChildResponse(
    val childId: Long,
    val name: String,
    val birthDate: String,
    val gender: String,
    val weight: Double,
    val height: Int
)
