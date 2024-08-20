package com.hana.aiforkid.child.infra

import com.hana.aiforkid.child.domain.Child
import org.springframework.data.jpa.repository.JpaRepository

interface ChildRepsitory : JpaRepository<Child, Long> {
    fun findByParentId(parentId: Long): Child?
}