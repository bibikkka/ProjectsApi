package com.example.projectsapi.controller.user

import com.example.projectsapi.jpa.User
import com.example.projectsapi.model.responses.ServiceResponse
import com.example.projectsapi.model.responses.UserResponse
import com.example.projectsapi.repository.UserRepository
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse


@RestController
@Tag(name = "User API", description = "All about users")
@RequestMapping("/api2/users/")
class UserController(
    private var userRepository: UserRepository
) {

    @GetMapping("/getByRole")
    fun getUsersByRole(
        @RequestParam role: String,
        response: HttpServletResponse
    ): ServiceResponse<UserResponse>? {
        val userCandidate: List<User> = userRepository.findAllByRole(role)

        if (userCandidate.isNotEmpty()) {
            val user = mutableListOf<UserResponse>()

            for ( i in userCandidate.indices){
                user.add(
                    UserResponse(
                        id = userCandidate[i].id,
                        username = userCandidate[i].username,
                        name = userCandidate[i].name,
                        email = userCandidate[i].email,
                        password = userCandidate[i].password,
                        role = userCandidate[i].role,
                    )
                )
            }

            return ServiceResponse(
                data = user,
                status = HttpStatus.OK,
                message = "Everything is fine"
            )
        } else {
            return ServiceResponse(
                data = null,
                status = HttpStatus.BAD_REQUEST,
                message = "Users with this role not found"
            )
        }
    }

}

























