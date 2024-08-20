package com.hana.aiforkid.parent.domain

import com.hana.aiforkid.common.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Parent(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0L,

    @Column(name = "name")
    val name: String
) : BaseEntity() {
    companion object {
        fun of(name: String) = Parent(
            name = name
        )
    }
}