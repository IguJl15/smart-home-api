package com.nebraska.homecontrol.app.place.entities

import jakarta.persistence.*

@Entity
data class Room(
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(nullable = false)
    val name: String = "",

    @OneToMany
    val devices: List<Device> = emptyList()
)