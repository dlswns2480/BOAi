package com.hana.aiforkid.parent.infra

import com.hana.aiforkid.parent.domain.Parent
import org.springframework.data.jpa.repository.JpaRepository

interface ParentRepository : JpaRepository<Parent, Long> {
}