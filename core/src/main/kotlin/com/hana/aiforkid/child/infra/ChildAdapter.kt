package com.hana.aiforkid.child.infra

import com.hana.aiforkid.child.domain.Child
import com.hana.aiforkid.child.domain.ChildPort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ChildAdapter(
    private val childRepository: ChildRepsitory
) : ChildPort {
    override fun persist(child: Child): Child {
        return childRepository.save(child)
    }

    override fun loadByParentId(parentId: Long): Child? {
        return childRepository.findByParentId(parentId)
    }

    override fun loadById(id: Long): Child? {
        return childRepository.findByIdOrNull(id)
    }

    override fun loadAll(): List<Child> {
        return childRepository.findAll()
    }

}