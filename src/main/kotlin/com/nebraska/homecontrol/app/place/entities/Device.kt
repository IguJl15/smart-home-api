package com.nebraska.homecontrol.app.place.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Device(
    @Id
    @GeneratedValue
    val name: String = "",

    @Column(nullable = false)
    val description: String = "",

    /// Indicates if the device is active on the network (sending ping requests with data)
    @Column(nullable = false)
    val active: Boolean = false,

    /// Indicates the current device state while it is active
    @Column(nullable = false)
    val on: Boolean = false
)
