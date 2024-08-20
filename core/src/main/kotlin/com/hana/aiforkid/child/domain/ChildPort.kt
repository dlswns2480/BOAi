package com.hana.aiforkid.child.domain

interface ChildPort {
    fun persist(child: Child): Child

    fun loadByParentId(parentId: Long): Child?

    fun loadById(id: Long): Child?

    fun loadAll(): List<Child>
}