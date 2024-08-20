package com.hana.aiforkid.parent.infra

import com.hana.aiforkid.parent.domain.Parent
import com.hana.aiforkid.parent.domain.ParentPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ParentAdapter(
    private val parentRepository: ParentRepository
) : ParentPort{
    override fun loadById(id: Long): Parent? {
        return parentRepository.findByIdOrNull(id)
    }

    override fun persist(parent: Parent): Parent {
        return parentRepository.save(parent)
    }

    override fun loadAll(): List<Parent> {
        return parentRepository.findAll()
    }
}