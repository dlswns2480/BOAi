package com.hana.aiforkid.child

import com.hana.aiforkid.child.application.ChildService
import com.hana.aiforkid.child.domain.ChildAbility
import com.hana.aiforkid.child.exception.ChildErrorCode
import com.hana.aiforkid.child.dto.request.ApiAddChildRequest
import com.hana.aiforkid.child.dto.request.toDto
import com.hana.aiforkid.common.exception.ErrorOperation
import com.hana.aiforkid.child.dto.respoonse.AddChildResponse
import com.hana.aiforkid.child.dto.respoonse.ChildResponse
import com.hana.aiforkid.child.dto.respoonse.GetProsAndConsResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "child", description = "CHILD API")
@RestController
@RequestMapping("/api/v1/child")
class ChildController(
    private val childService: ChildService
) {
    @PostMapping
    @Operation(summary = "우리 아이 추가 API")
    fun addChild(
        @RequestBody request: ApiAddChildRequest
    ): ResponseEntity<AddChildResponse> {
        return ResponseEntity.ok(childService.addChild(request.toDto()))
    }

    @GetMapping
    @Operation(summary = "우리 아이 리스트 조회 API")
    fun getChildren(): ResponseEntity<ChildResponse> {
        return ResponseEntity.ok(childService.getChildren())
    }

    @GetMapping("/result/{childId}")
    @Operation(summary = "총 발달분석 결과 API")
    @ErrorOperation(ChildErrorCode::class)
    fun getAbilityResult(
        @PathVariable("childId") childId: Long
    ): ResponseEntity<ChildAbility> {
        return ResponseEntity.ok(childService.getAnalysisResult(childId))
    }

    @GetMapping("/result/average")
    @Operation(summary = "평균 발달분석 결과 조회 API")
    fun getAverage() =
        ResponseEntity.ok(childService.getAverageAnalysisResult())

    @GetMapping("/{childId}/prosAndCons")
    @Operation(summary = "아이 장단점 조회 API")
    fun getProsAndCons(
        @PathVariable("childId") childId: Long
    ): ResponseEntity<GetProsAndConsResponse> {
        return ResponseEntity.ok(childService.getProsAndCons(childId))
    }
}