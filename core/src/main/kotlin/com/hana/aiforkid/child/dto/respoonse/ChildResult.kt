package com.hana.aiforkid.child.dto.respoonse

data class ChildResult(
    val childId: Long,
    val name: String,
    val birthDate: String,
    val gender: String,
    val weight: Double,
    val height: Int
)
