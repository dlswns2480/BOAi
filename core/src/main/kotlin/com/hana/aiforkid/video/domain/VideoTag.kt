package com.hana.aiforkid.video.domain

import jakarta.persistence.*

@Entity
class VideoTag(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0L,

    @Column(name = "video_id")
    val videoId: Long,

    @Column(name = "hash_tag")
    @Enumerated(EnumType.STRING)
    val hashTag: HashTag
) {
}