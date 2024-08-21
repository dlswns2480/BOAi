package com.hana.aiforkid.video.application

import com.hana.aiforkid.common.exception.ClientValidationException
import com.hana.aiforkid.common.exception.NotFoundCustomException
import com.hana.aiforkid.s3.domain.S3Port
import com.hana.aiforkid.video.domain.Video
import com.hana.aiforkid.video.domain.VideoPort
import com.hana.aiforkid.video.dto.request.AddVideoInfoRequest
import com.hana.aiforkid.video.dto.request.AnalyzeVideoRequest
import com.hana.aiforkid.video.dto.response.AddVideoInfoResponse
import com.hana.aiforkid.video.dto.response.AnalyzeVideoResponse
import com.hana.aiforkid.video.dto.response.GetVideoResponse
import com.hana.aiforkid.video.dto.response.GetVideoesResponse
import com.hana.aiforkid.video.exception.VideoErrorCode
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
@Transactional(readOnly = true)
class VideoService(
    private val s3Port: S3Port,
    private val videoPort: VideoPort
) {

    @Transactional
    fun analyze(request: AnalyzeVideoRequest, file: MultipartFile): AnalyzeVideoResponse {
        /**
         * 영상분석 API
         */
        val savedVideo = s3Port.persist(file)
            ?: throw ClientValidationException(VideoErrorCode.FAILED_TO_SAVE_VIDEO)
        val video = Video(
            childId = request.childId,
            title = "영상 제목",
            videoPath = savedVideo
        )
        videoPort.persist(video)
        /**
         * 영상 분석 결과 리턴
         */
        return AnalyzeVideoResponse(score = 10)
    }

    fun getVideoes(childId: Long): GetVideoesResponse {
        val videoes = videoPort.loadAllByChildId(childId)
        val videoResponse = videoes.map {
            GetVideoResponse(title = it.title, videoPath = it.videoPath)
        }

        return GetVideoesResponse(videoResponse)
    }

    @Transactional
    fun addInfo(
        videoId: Long,
        request: AddVideoInfoRequest
    ): AddVideoInfoResponse {
        val video = (videoPort.loadById(videoId)
            ?: throw NotFoundCustomException(VideoErrorCode.NOT_FOUND_VIDEO))

        video.insertTitle(request.title)

        return AddVideoInfoResponse(video.id, video.title)
    }

}