package com.example.projectsapi.model.responses

import kotlinx.serialization.Serializable
import org.springframework.http.HttpStatus

@Serializable
data class ServiceResponse<T>(
    var data: List<T>? = null,
    var status: HttpStatus,
    var message: String = ""
)