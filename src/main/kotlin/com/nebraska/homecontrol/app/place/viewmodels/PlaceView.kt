package com.nebraska.homecontrol.app.place.viewmodels

import com.nebraska.homecontrol.app.place.entities.Place
import com.nebraska.homecontrol.app.place.entities.Room

data class PlaceView(
    val id: Long, val name: String, val room: List<Room>
) {
    companion object {
        fun from(place: Place) = PlaceView(place.id!!, place.name, place.rooms)
    }
}