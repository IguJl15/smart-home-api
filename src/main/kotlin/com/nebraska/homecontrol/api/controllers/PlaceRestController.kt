package com.nebraska.homecontrol.api.controllers

import com.nebraska.homecontrol.app.place.commands.CreatePlaceCommand
import com.nebraska.homecontrol.app.place.dtos.CreatePlaceDto
import com.nebraska.homecontrol.app.place.queries.GetAllPlaces
import com.nebraska.homecontrol.app.place.queries.GetPlaceByIdQuery
import com.nebraska.homecontrol.app.place.viewmodels.PlaceView
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.validation.Valid
import jakarta.validation.constraints.PositiveOrZero
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@ApiV1RestController
class PlaceRestController(
    val createPlaceCommand: CreatePlaceCommand,
    val getPlaceByIdQuery: GetPlaceByIdQuery,
    val getAllPlaces: GetAllPlaces
) {

    @PostMapping("/places")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Place created successfully"),
            ApiResponse(responseCode = "400", description = "Validation error")
        ]
    )
    fun create(@Valid @RequestBody dto: CreatePlaceDto): Unit {
        createPlaceCommand(dto).getOrThrow()
    }

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Place found"),
            ApiResponse(responseCode = "404", description = "Place not found", content = [Content()])
        ]
    )
    fun getById(@PositiveOrZero @PathVariable id: Long): PlaceView {
        return getPlaceByIdQuery(id).getOrThrow()
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(responseCode = "200", description = "Places found")
    fun getAll(): List<PlaceView> {
        return getAllPlaces(Unit).getOrThrow()
    }


    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "204", description = "Place found"),
            ApiResponse(responseCode = "404", description = "Place not found", content = [Content()])
        ]
    )
    fun delete(@PositiveOrZero @PathVariable id: Long): PlaceView {
        return getPlaceByIdQuery(id).getOrThrow()
    }
}