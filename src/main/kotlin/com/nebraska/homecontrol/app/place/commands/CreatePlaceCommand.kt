package com.nebraska.homecontrol.app.place.commands

import com.nebraska.homecontrol.app.common.usecase.CommandUseCase
import com.nebraska.homecontrol.app.place.dtos.CreatePlaceDto
import com.nebraska.homecontrol.app.place.entities.Place
import com.nebraska.homecontrol.app.place.queries.GetPlaceByIdQuery
import com.nebraska.homecontrol.app.place.repository.PlaceRepository
import org.springframework.stereotype.Service

@Service
class CreatePlaceCommand(
    private val getPlaceById: GetPlaceByIdQuery,
    private val repository: PlaceRepository
) : CommandUseCase<CreatePlaceDto, Unit> {


    override fun invoke(args: CreatePlaceDto): Result<Unit> {
        val newPlace = Place(
            name = args.name,
            rooms = emptyList(),
            owner = args.owner
        )

        repository.save(newPlace)

        return Result.success(Unit)
    }
}