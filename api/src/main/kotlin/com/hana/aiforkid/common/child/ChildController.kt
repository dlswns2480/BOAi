package com.hana.aiforkid.common.child

import com.hana.aiforkid.common.child.dto.request.ApiAddChildRequest
import com.hana.aiforkid.common.child.dto.request.toDto
import com.hana.aiforkid.parent.application.ParentService
import com.hana.aiforkid.parent.dto.respoonse.AddChildResponse
import com.hana.aiforkid.parent.dto.respoonse.ChildResponse
import com.hana.aiforkid.parent.dto.respoonse.ChildResult
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "child", description = "마이페이지 API")
@RestController
@RequestMapping("/api/v1/child")
class ChildController(
    private val parentService: ParentService
) {
    @PostMapping
    @Operation(summary = "우리 아이 추가 API")
    fun addChild(
        @RequestBody request: ApiAddChildRequest
    ): ResponseEntity<AddChildResponse> {
        return ResponseEntity.ok(parentService.addChild(request.toDto()))
    }

    @GetMapping
    @Operation(summary = "우리 아이 리스트 조회 API")
    fun getChildren(): ResponseEntity<ChildResponse> {
        return ResponseEntity.ok(parentService.getChildren())
    }
}