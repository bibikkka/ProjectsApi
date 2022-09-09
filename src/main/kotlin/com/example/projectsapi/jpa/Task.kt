package com.example.projectsapi.jpa

import javax.persistence.*

@Entity
@Table(name = "tasks")
data class Tasks (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0,

    @Column(name="projectID")
    var projectID: Int? = null,

    @Column(name="status")
    var status: String? = null,

    @Column(name="executor_name")
    var executorName: String? = null,

    @Column(name="title")
    var title: String? = null,

    @Column(name="date_start")
    var dateStart: String? = null,

    @Column(name="date_end")
    var dateEnd: String? = null,

    @Column(name="description")
    var description: String? = null,
)