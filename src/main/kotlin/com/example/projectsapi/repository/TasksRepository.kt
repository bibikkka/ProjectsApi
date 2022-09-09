package com.example.projectsapi.repository

import com.example.projectsapi.jpa.Tasks
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
@EnableJpaRepositories
interface TasksRepository: JpaRepository<Tasks, Long> {

    fun findAllByProjectID(projectID: Int): List<Tasks>
}