package com.hana.aiforkid.common.exception

open class BoaiException(
    val errorCode: ErrorCode,
) : RuntimeException(errorCode.message)

class ClientValidationException(errorCode: ErrorCode) : BoaiException(errorCode)

class InvalidRequestException(errorCode: ErrorCode) : BoaiException(errorCode)

class NotFoundCustomException(errorCode: ErrorCode) : BoaiException(errorCode)