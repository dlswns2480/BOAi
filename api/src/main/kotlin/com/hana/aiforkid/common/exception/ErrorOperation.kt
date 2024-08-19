package com.hana.aiforkid.common.exception

import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ErrorOperation(val value: KClass<out ErrorCode>)
