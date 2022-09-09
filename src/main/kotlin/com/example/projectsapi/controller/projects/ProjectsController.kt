package com.example.projectsapi.controller.projects

import com.example.projectsapi.jpa.Projects
import com.example.projectsapi.jpa.Tasks
import com.example.projectsapi.model.projects.NewProject
import com.example.projectsapi.model.responses.ServiceResponse
import com.example.projectsapi.model.tasks.NewTasks
import com.example.projectsapi.repository.ProjectsRepository
import com.example.projectsapi.repository.TasksRepository
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

@RestController
@Tag(name = "Projects API", description = "All about projects")
@RequestMapping("/api2/projects/")
class ProjectsController (
    private val projectsRepository: ProjectsRepository,
    private val tasksRepository: TasksRepository
) {

    @PostMapping("/tasks/add")
    fun addTasks(
        @Valid @RequestBody newTasks: NewTasks,
        response: HttpServletResponse
    ): ServiceResponse<Boolean>? {

        return try {
            tasksRepository.save(
                Tasks(
                    title = newTasks.title,
                    id = 0,
                    projectID = newTasks.projectID,
                    status = newTasks.status,
                    dateStart = newTasks.dateStart,
                    dateEnd = newTasks.dateEnd,
                    executorName = newTasks.executorName,
                    description = newTasks.description
                )
            )

            ServiceResponse(
                data = listOf(true),
                message = "Everything is fine",
                status = HttpStatus.OK
            )

        } catch (e: Exception) {
            ServiceResponse(
                data = listOf(false),
                message = e.message.toString(),
                status = HttpStatus.BAD_REQUEST
            )
        }
    }

    @PostMapping("/tasks/")
    fun getTasks(
        @RequestParam id: Int,
        response: HttpServletResponse
    ): ServiceResponse<Tasks>? {

        return try {
            val tasks = tasksRepository.findAllByProjectID(id)

            ServiceResponse(
                data = tasks.toList(),
                message = "Everything is fine",
                status = HttpStatus.OK
            )

        } catch (e: Exception) {
            ServiceResponse(
                data = listOf(),
                message = e.message.toString(),
                status = HttpStatus.BAD_REQUEST
            )
        }

    }

    @PostMapping("/add")
    fun addProject(
        @Valid @RequestBody newProject: NewProject,
        response: HttpServletResponse
    ): ServiceResponse<Boolean>? {

        return try {
            projectsRepository.save(
                Projects(
                    id = 0,
                    title = newProject.title,
                    dateStart = newProject.dateStart,
                    dateEnd = newProject.dateEnd,
                    orderName = newProject.orderName,
                    status = newProject.status
                )
            )

            ServiceResponse(
                data = listOf(true),
                message = "Everything is fine",
                status = HttpStatus.OK
            )

        } catch (e: Exception) {
            ServiceResponse(
                data = listOf(false),
                message = e.message.toString(),
                status = HttpStatus.BAD_REQUEST
            )
        }

    }

    @PostMapping("")
    fun getProjects(
        status: String?,
        response: HttpServletResponse
    ): ServiceResponse<Projects>? {

        return try {
            val projects = mutableListOf<Projects>()
            if(status == null) {
                projects.addAll(projectsRepository.findAll())
            } else {
                projects.addAll(projectsRepository.findAllByStatus(status))
            }
            ServiceResponse(
                data = projects.toList(),
                message = "Everything is fine",
                status = HttpStatus.OK
            )

        } catch (e: Exception) {
            ServiceResponse(
                data = listOf(),
                message = e.message.toString(),
                status = HttpStatus.BAD_REQUEST
            )
        }

    }

    @PostMapping("delete")
    fun deleteProjects(
        @RequestParam id: Int,
        response: HttpServletResponse
    ): ServiceResponse<Boolean>? {

        return try {
            projectsRepository.deleteById(id.toLong())

            ServiceResponse(
                data = listOf(true),
                message = "Everything is fine",
                status = HttpStatus.OK
            )

        } catch (e: Exception) {
            ServiceResponse(
                data = listOf(false),
                message = e.message.toString(),
                status = HttpStatus.BAD_REQUEST
            )
        }

    }

}
























