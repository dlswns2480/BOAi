package com.hana.aiforkid.child.exception

import com.hana.aiforkid.common.exception.ErrorCode

enum class ChildErrorCode(
    override val message: String,
    override val code: String
) : ErrorCode {
    INVALID_GENDER("성별 형식이 올바르지 않습니다.", "C_001")
}