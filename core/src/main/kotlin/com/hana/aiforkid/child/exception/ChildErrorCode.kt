package com.hana.aiforkid.child.exception

import com.hana.aiforkid.common.exception.ErrorCode

enum class ChildErrorCode(
    override val message: String,
    override val code: String
) : ErrorCode {
    INVALID_GENDER("성별 형식이 올바르지 않습니다.", "C_001"),
    NOT_FOUND_ACTING_RESULT("해당 아이의 분석 결과가 존재하지 않습니다.", "C_002");
}