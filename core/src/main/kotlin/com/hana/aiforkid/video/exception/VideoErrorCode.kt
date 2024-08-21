package com.hana.aiforkid.video.exception

import com.hana.aiforkid.common.exception.ErrorCode

enum class VideoErrorCode(
    override val message: String,
    override val code: String
) : ErrorCode{
    FAILED_TO_SAVE_VIDEO("영상 저장에 실패했습니다.", "V_001"),
    NOT_FOUND_VIDEO("존재하지 않는 영상입니다.", "V_002")
}