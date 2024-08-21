package com.hana.aiforkid.video.dto.response

import com.hana.aiforkid.video.domain.Video

data class GetVideoesResponse(
    val video: List<GetVideoResponse>
)

data class GetVideoResponse(
    val title: String,
    val videoPath: String
)