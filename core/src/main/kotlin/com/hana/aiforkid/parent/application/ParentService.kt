package com.hana.aiforkid.parent.application

import com.hana.aiforkid.child.domain.Child
import com.hana.aiforkid.child.domain.ChildPort
import com.hana.aiforkid.common.util.DateFormatter
import com.hana.aiforkid.parent.domain.Parent
import com.hana.aiforkid.parent.domain.ParentPort
import com.hana.aiforkid.parent.dto.request.AddChildRequest
import com.hana.aiforkid.parent.dto.request.RegisterParentRequest
import com.hana.aiforkid.parent.dto.respoonse.AddChildResponse
import com.hana.aiforkid.parent.dto.respoonse.ChildResponse
import com.hana.aiforkid.parent.dto.respoonse.ChildResult
import com.hana.aiforkid.parent.dto.respoonse.RegisterParentResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.format.DateTimeFormatter

@Service
@Transactional(readOnly = true)
class ParentService(
    private val parentPort: ParentPort,
    private val childPort: ChildPort
) {
    @Transactional
    fun register(request: RegisterParentRequest): RegisterParentResponse {
       val parent = Parent.of(name = request.name)
       val savedParent = parentPort.persist(parent)
       return RegisterParentResponse(
           id = savedParent.id,
           name = savedParent.name
       )
   }

    @Transactional
    fun addChild(request: AddChildRequest): AddChildResponse {
        val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
        val child = Child.of(
            parentId = 1L,
            name = request.name,
            birthDate = request.birthDate,
            gender = request.gender,
            weight = request.weight,
            height = request.height
        )
        val savedChild = childPort.persist(child)
        return AddChildResponse(
            birthDate = savedChild.birthDate.format(formatter),
            gender = savedChild.gender.description,
            weight = savedChild.weight,
            height = savedChild.height
        )
    }


    fun getChildren(): ChildResponse {
        val children = childPort.loadAll()
        val result = children.map {
            ChildResult(
                name = it.name,
                birthDate = it.birthDate.format(DateFormatter.getFormatter()),
                gender = it.gender.description,
                weight = it.weight,
                height = it.height
            )
        }
        return ChildResponse(child = result)
    }


}