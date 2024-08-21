package com.hana.aiforkid.video.domain

interface VideoPort {
    fun persist(video: Video): Video

    fun loadAllByChildId(childId: Long): List<Video>

    fun loadById(id: Long): Video?
}