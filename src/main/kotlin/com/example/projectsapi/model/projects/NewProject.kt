package com.example.projectsapi.model.projects

data class NewProject(
    var title: String? = null,
    var orderName: String? = null,
    var dateStart: String? = null,
    var dateEnd: String? = null,
    var status: String? = null,
)