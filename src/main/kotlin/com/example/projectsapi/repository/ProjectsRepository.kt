package com.example.projectsapi.repository

import com.example.projectsapi.jpa.Projects
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectsRepository: JpaRepository<Projects, Long> {

}