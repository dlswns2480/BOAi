package com.hana.aiforkid.parent.domain

interface ParentPort {
    fun loadById(id: Long): Parent?

    fun persist(parent: Parent): Parent

    fun loadAll(): List<Parent>
}