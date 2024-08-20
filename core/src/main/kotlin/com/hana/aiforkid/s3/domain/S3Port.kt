package com.hana.aiforkid.s3.domain

import org.springframework.web.multipart.MultipartFile

interface S3Port {
    fun persist(file: MultipartFile): String?
}