package com.nebraska.homecontrol.app.place.repository

import com.nebraska.homecontrol.app.place.entities.Place
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaceRepository : CrudRepository<Place, Long?>