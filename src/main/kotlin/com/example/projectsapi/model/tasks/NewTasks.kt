package com.example.projectsapi.model.tasks

data class NewTasks(
    var projectID: Int? = null,
    var status: String? = null,
    var executorName: String? = null,
    var dateStart: String? = null,
    var dateEnd: String? = null,
    var description: String? = null,
    var title: String? = null,
)
