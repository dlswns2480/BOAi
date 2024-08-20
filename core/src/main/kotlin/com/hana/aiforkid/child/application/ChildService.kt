package com.hana.aiforkid.child.application

import com.hana.aiforkid.child.domain.Child
import com.hana.aiforkid.child.domain.ChildAbility
import com.hana.aiforkid.child.domain.ChildAbilityPort
import com.hana.aiforkid.child.domain.ChildPort
import com.hana.aiforkid.child.exception.ChildErrorCode
import com.hana.aiforkid.common.exception.ClientValidationException
import com.hana.aiforkid.common.util.DateFormatter
import com.hana.aiforkid.parent.domain.Parent
import com.hana.aiforkid.parent.domain.ParentPort
import com.hana.aiforkid.child.dto.request.AddChildRequest
import com.hana.aiforkid.child.dto.request.RegisterParentRequest
import com.hana.aiforkid.child.dto.respoonse.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.format.DateTimeFormatter

@Service
@Transactional(readOnly = true)
class ChildService(
    private val parentPort: ParentPort,
    private val childPort: ChildPort,
    private val childAbilityPort: ChildAbilityPort
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
            childId = savedChild.id,
            name = savedChild.name,
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
                childId = it.id,
                name = it.name,
                birthDate = it.birthDate.format(DateFormatter.getFormatter()),
                gender = it.gender.description,
                weight = it.weight,
                height = it.height
            )
        }
        return ChildResponse(child = result)
    }

    fun getAnalysisResult(childId: Long) : ChildAbility{
        val ability = (childAbilityPort.loadByChildId(childId)
            ?: throw ClientValidationException(ChildErrorCode.NOT_FOUND_ACTING_RESULT))
        return ability
    }

    fun getAverageAnalysisResult(): ChildAbility {
        return ChildAbility.getAverage()
    }

    fun getProsAndCons(childId: Long): GetProsAndConsResponse {
        val ability = getAnalysisResult(childId)
        return getMaxAndMin(ability)
    }

    private fun getMaxAndMin(ability: ChildAbility): GetProsAndConsResponse {
        var maxProperty = ""
        var max = Integer.MIN_VALUE;

        if(ability.bigMuscle > max) {
            max = ability.bigMuscle
            maxProperty = "대근육"
        }
        else if(ability.smallMuscle > max) {
            max = ability.smallMuscle
            maxProperty = "소근육"
        }
        else if(ability.recognition > max) {
            max = ability.recognition
            maxProperty = "인지"
        }
        else if(ability.language > max) {
            max = ability.language
            maxProperty = "언어"
        }
        else if(ability.sociality > max) {
            max = ability.sociality
            maxProperty = "사회성"
        }
        else if(ability.selfHelp > max) {
            max = ability.selfHelp
            maxProperty = "자조"
        }

        var minProperty = ""
        var min = Integer.MAX_VALUE

        if(ability.bigMuscle < min) {
            min = ability.bigMuscle
            minProperty = "대근육"
        }
        else if(ability.smallMuscle > min) {
            min = ability.smallMuscle
            minProperty = "소근육"
        }
        else if(ability.recognition > min) {
            min = ability.recognition
            minProperty = "인지"
        }
        else if(ability.language > min) {
            min = ability.language
            minProperty = "언어"
        }
        else if(ability.sociality > max) {
            min = ability.sociality
            minProperty = "사회성"
        }
        else if(ability.selfHelp > min) {
            min = ability.selfHelp
            minProperty = "자조"
        }

        return GetProsAndConsResponse(pros = maxProperty, cons = minProperty)
    }
}