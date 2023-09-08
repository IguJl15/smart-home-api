package com.nebraska.homecontrol.app.place.commands

import com.nebraska.homecontrol.app.common.usecase.CommandUseCase
import com.nebraska.homecontrol.app.place.repository.RoomRepository


class DeleteAllRoomsByIdsCommand(
    private val repository: RoomRepository,
    private val deleteRooms: DeleteAllRoomsCommand
) : CommandUseCase<List<Long>, Unit> {
    override fun invoke(args: List<Long>): Result<Unit> {
        val rooms = repository.findAllById(args)

        return deleteRooms(rooms)
    }
}