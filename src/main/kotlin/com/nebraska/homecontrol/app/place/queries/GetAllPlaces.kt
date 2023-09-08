package com.nebraska.homecontrol.app.place.queries

import com.nebraska.homecontrol.app.common.usecase.QueryUseCase
import com.nebraska.homecontrol.app.place.repository.PlaceRepository
import com.nebraska.homecontrol.app.place.viewmodels.PlaceView
import org.springframework.stereotype.Service

@Service
class GetAllPlaces(private val repository: PlaceRepository) : QueryUseCase<Unit, List<PlaceView>> {
    override fun invoke(args: Unit): Result<List<PlaceView>> {
        return Result.success(
            repository.findAll().map { PlaceView.from(it) }
        )
    }
}