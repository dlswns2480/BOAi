package com.hana.aiforkid.video.infra

import com.hana.aiforkid.video.domain.Video
import com.hana.aiforkid.video.domain.VideoPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class VideoAdapter(
    private val videoRepository: VideoRepository
) : VideoPort {
    override fun persist(video: Video): Video {
        return videoRepository.save(video)
    }

    override fun loadAllByChildId(childId: Long): List<Video> {
        return videoRepository.findAllByChildId(childId);
    }

    override fun loadById(id: Long): Video? {
        return videoRepository.findByIdOrNull(id)
    }
}