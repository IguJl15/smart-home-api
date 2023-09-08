package com.nebraska.homecontrol.app.place.commands

import com.nebraska.homecontrol.app.common.usecase.CommandUseCase
import com.nebraska.homecontrol.app.place.entities.Room
import com.nebraska.homecontrol.app.place.repository.RoomRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DeleteAllRoomsCommand(
    private val repository: RoomRepository
) : CommandUseCase<Iterable<Room>, Unit> {
    override fun invoke(args: Iterable<Room>): Result<Unit> {
        if (args.any { r -> r.devices.any { it.active } }) {
            return Result.failure(
                ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't delete a room with active(s) devices")
            )
        }

        repository.deleteAll(args)

        return Result.success(Unit)
    }
}