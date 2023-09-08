package com.nebraska.homecontrol.app.place.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreatePlaceDto(
    @get:NotBlank
    @get:Size(min = 3, max = 48)
    val name: String,

    @get:NotBlank
    @get:Size(min = 3, max = 32)
    val owner: String
)