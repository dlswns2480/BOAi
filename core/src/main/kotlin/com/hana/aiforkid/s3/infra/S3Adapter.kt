package com.hana.aiforkid.s3.infra

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.ObjectMetadata
import com.hana.aiforkid.s3.domain.S3Port
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.IOException

@Component
class S3Adapter(
    private val amazonS3Client: AmazonS3
) : S3Port {
    private val logger = KotlinLogging.logger { }

    @Value("\${cloud.aws.s3.bucket}")
    lateinit var bucket: String

    override fun persist(file: MultipartFile): String? {
        if (file.size == 0L || file.isEmpty()) {
            return null
        }

        val originalFilename: String? = file.originalFilename
        val convertName = "upload/$originalFilename"

        val metadata = ObjectMetadata()
        metadata.contentLength = file.size
        metadata.contentType = file.contentType

        try {
            amazonS3Client.putObject(bucket, convertName, file.inputStream, metadata)
        } catch (e: IOException) {
            logger.error { e.message }
        }
        return amazonS3Client.getUrl(bucket, convertName).toString()
    }
}