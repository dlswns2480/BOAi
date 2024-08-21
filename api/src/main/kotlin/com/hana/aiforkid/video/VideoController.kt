package com.hana.aiforkid.video

import com.hana.aiforkid.common.exception.ErrorOperation
import com.hana.aiforkid.video.application.VideoService
import com.hana.aiforkid.video.dto.request.AddVideoInfoRequest
import com.hana.aiforkid.video.dto.request.AnalyzeVideoRequest
import com.hana.aiforkid.video.dto.response.AddVideoInfoResponse
import com.hana.aiforkid.video.dto.response.AnalyzeVideoResponse
import com.hana.aiforkid.video.dto.response.GetVideoesResponse
import com.hana.aiforkid.video.exception.VideoErrorCode
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/video")
class VideoController(
    private val videoService: VideoService
) {
    @PostMapping
    @Operation(summary = "영상분석 API")
    fun analyzeVideo(
        @RequestPart(value = "data") request: AnalyzeVideoRequest,
        @RequestPart(value = "video") file: MultipartFile
    ): ResponseEntity<AnalyzeVideoResponse> {
        return ResponseEntity.ok(videoService.analyze(request, file))
    }

    @GetMapping("/{childId}")
    @Operation(summary = "영상 리스트 조회 API")
    fun getVideoes(
        @PathVariable("childId") childId: Long
    ): ResponseEntity<GetVideoesResponse> {
        return ResponseEntity.ok(videoService.getVideoes(childId))
    }

    @PostMapping("/title/{videoId}")
    @Operation(summary = "영상 제목 등록 API")
    @ErrorOperation(VideoErrorCode::class)
    fun addTitle(
        @PathVariable("videoId") videoId: Long,
        @RequestBody request: AddVideoInfoRequest
    ): ResponseEntity<AddVideoInfoResponse> {
        return ResponseEntity.ok(videoService.addInfo(videoId, request))
    }
}