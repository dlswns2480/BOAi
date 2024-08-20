package com.hana.aiforkid.common.child.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.hana.aiforkid.parent.domain.Gender
import com.hana.aiforkid.parent.dto.request.AddChildRequest
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class ApiAddChildRequest(
    val name: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    @Schema(description = "날짜 형식 yyyy.MM.dd로 보내주시면 됩니다.")
    val birthDate: LocalDateTime,
    @Schema(description = "남자 or 여자")
    val gender: String,
    val weight: Double,
    val height: Int
)

fun ApiAddChildRequest.toDto() = AddChildRequest(
    name = this.name,
    birthDate = this.birthDate,
    gender = Gender.of(this.gender),
    weight = this.weight,
    height = this.height
)
