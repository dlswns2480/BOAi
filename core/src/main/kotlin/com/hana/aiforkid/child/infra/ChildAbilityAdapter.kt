package com.hana.aiforkid.child.infra

import com.hana.aiforkid.child.domain.ChildAbility
import com.hana.aiforkid.child.domain.ChildAbilityPort
import org.springframework.stereotype.Repository

@Repository
class ChildAbilityAdapter(
    private val childAbilityRepository: ChildAbilityRepository
) : ChildAbilityPort{
    override fun loadByChildId(childId: Long): ChildAbility? {
        return childAbilityRepository.findByChildId(childId)
    }
}