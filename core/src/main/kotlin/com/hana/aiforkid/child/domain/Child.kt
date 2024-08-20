package com.hana.aiforkid.child.domain

import com.hana.aiforkid.common.entity.BaseEntity
import com.hana.aiforkid.parent.domain.Gender
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
class Child(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(name = "parent_id")
    val parentId: Long,

    @Column(name = "name")
    val name: String,

    @Column(name = "birthDate")
    val birthDate: LocalDate,

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    val gender: Gender,

    @Column(name = "weight")
    val weight: Double,

    @Column(name = "height")
    val height: Int
) : BaseEntity() {
    companion object {
        fun of(
            parentId: Long,
            name: String,
            birthDate: LocalDate,
            gender: Gender,
            weight: Double,
            height: Int
        ) = Child(
            parentId = parentId,
            name = name,
            birthDate = birthDate,
            gender = gender,
            weight = weight,
            height = height
        )
    }

}