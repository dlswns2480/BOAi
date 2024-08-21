package com.hana.aiforkid.video.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Video(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0L,

    @Column(name = "child_id")
    val childId: Long,

    @Column(name = "title")
    var title: String,

    @Column(name = "video_path")
    val videoPath: String
) {
    fun insertTitle(title: String) {
        this.title = title
    }
}