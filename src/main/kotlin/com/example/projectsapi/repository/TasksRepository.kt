package com.example.projectsapi.repository

import com.example.projectsapi.jpa.Tasks
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TasksRepository: JpaRepository<Tasks, Long> {

    fun findAllByProjectID(projectID: Int): List<Tasks>
}