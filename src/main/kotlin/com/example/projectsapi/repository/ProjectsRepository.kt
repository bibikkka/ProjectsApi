package com.example.projectsapi.repository

import com.example.projectsapi.jpa.Projects
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
@EnableJpaRepositories
interface ProjectsRepository: JpaRepository<Projects, Long> {

    fun findAllByStatus(status: String): List<Projects>
}