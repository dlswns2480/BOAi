package com.hana.aiforkid.child.domain

import com.hana.aiforkid.common.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class ChildAbility(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0L,

    @Column(name = "child_id")
    val childId: Long,

    @Column(name = "big_muscle")
    val bigMuscle: Int,

    @Column(name = "small_muscle")
    val smallMuscle: Int,

    @Column(name = "recognition")
    val recognition: Int,

    @Column(name = "language")
    val language: Int,

    @Column(name = "sociality")
    val sociality: Int,

    @Column(name = "self_help")
    val selfHelp: Int


) : BaseEntity() {
    companion object {
        fun getAverage() = ChildAbility(
            childId = 0L,
            bigMuscle = 50,
            smallMuscle = 50,
            recognition = 50,
            language = 50,
            sociality = 50,
            selfHelp = 50
        )
    }
}