package com.hana.aiforkid.video.infra

import com.hana.aiforkid.video.domain.Video
import org.springframework.data.jpa.repository.JpaRepository

interface VideoRepository : JpaRepository<Video, Long>{
    fun findAllByChildId(childId: Long): List<Video>
}