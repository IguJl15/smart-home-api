package com.nebraska.homecontrol.app.place.repository

import com.nebraska.homecontrol.app.place.entities.Room
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository : CrudRepository<Room, Long?>