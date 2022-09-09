package com.example.projectsapi.jpa

import javax.persistence.*

@Entity
@Table(name = "users")
data class User (
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