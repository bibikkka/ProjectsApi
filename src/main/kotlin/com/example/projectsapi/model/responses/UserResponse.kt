package com.example.projectsapi.model.responses

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserResponse(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,

    @Column(name="username")
    var username: String? = null,

    @Column(name="name")
    var name: String? = null,

    @Column(name="email")
    var email: String? = null,

    @Column(name="password")
    var password: String? = null,

    @Column(name="role")
    var role: String? = null,
)