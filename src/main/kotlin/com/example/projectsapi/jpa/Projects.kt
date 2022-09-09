package com.example.projectsapi.jpa

import javax.persistence.*

@Entity
@Table(name = "projects")
data class Projects (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,

    @Column(name="title")
    var title: String? = null,

    @Column(name="order_name")
    var orderName: String? = null,

    @Column(name="date_start")
    var dateStart: String? = null,

    @Column(name="date_end")
    var dateEnd: String? = null,

    @Column(name="status")
    var status: String? = null,
)