package com.hana.aiforkid.child.domain

interface ChildAbilityPort {
    fun loadByChildId(childId: Long): ChildAbility?
}