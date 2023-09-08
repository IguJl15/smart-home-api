package com.nebraska.homecontrol.app.place.queries

import com.nebraska.homecontrol.app.common.usecase.QueryUseCase
import com.nebraska.homecontrol.app.place.repository.PlaceRepository
import com.nebraska.homecontrol.app.place.viewmodels.PlaceView
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class GetPlaceByIdQuery(private val repository: PlaceRepository) : QueryUseCase<Long, PlaceView> {
    override fun invoke(args: Long): Result<PlaceView> {
        return repository.findById(args)
            .map { Result.success(PlaceView.from(it)) }
            .orElseGet { Result.failure(ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found")) }
    }
}