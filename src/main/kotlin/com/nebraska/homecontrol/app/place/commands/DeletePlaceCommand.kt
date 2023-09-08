package com.nebraska.homecontrol.app.place.commands

import com.nebraska.homecontrol.app.common.usecase.CommandUseCase
import com.nebraska.homecontrol.app.place.queries.GetPlaceByIdQuery
import com.nebraska.homecontrol.app.place.repository.PlaceRepository
import org.springframework.stereotype.Service

@Service
class DeletePlaceCommand(
    private val getPlaceById: GetPlaceByIdQuery,
    private val deleteAllRooms: DeleteAllRoomsCommand,
    private val repository: PlaceRepository
) : CommandUseCase<Long, Unit> {
    override fun invoke(args: Long): Result<Unit> {
        val placeResult = getPlaceById(args)

        placeResult.onFailure { return Result.failure(placeResult.exceptionOrNull()!!) }

        val place = placeResult.getOrThrow()

        val deletedRooms = deleteAllRooms(place.room)

        return Result.success(Unit)
    }
}