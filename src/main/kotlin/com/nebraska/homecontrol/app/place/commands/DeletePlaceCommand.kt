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

        return placeResult.mapCatching { place ->
            val deletedRooms = deleteAllRooms(place.room)
            deletedRooms.getOrThrow()
        }.mapCatching {
            repository.deleteById(args)
        }
    }
}