package com.example.projectsapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProjectsApiApplication

fun main(args: Array<String>) {
    runApplication<ProjectsApiApplication>(*args)
}
