package com.example.projectsapi.model.user

data class NewUser(
    var username: String? = null,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var role: String? = null,
)
