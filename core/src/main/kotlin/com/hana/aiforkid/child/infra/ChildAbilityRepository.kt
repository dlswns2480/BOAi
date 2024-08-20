package com.hana.aiforkid.child.infra

import com.hana.aiforkid.child.domain.ChildAbility
import org.springframework.data.jpa.repository.JpaRepository


interface ChildAbilityRepository : JpaRepository<ChildAbility, Long>{
    fun findByChildId(childId: Long): ChildAbility?
}