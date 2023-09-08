package com.nebraska.homecontrol.app.place.entities

import jakarta.persistence.*

@Entity
data class Place(
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(nullable = false)
    val name: String = "",
    val owner: String = "",

    @OneToMany()
    val rooms: List<Room> = emptyList()
)