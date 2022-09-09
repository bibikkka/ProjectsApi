package com.example.projectsapi.controller.auth

import com.example.projectsapi.jpa.User
import com.example.projectsapi.model.responses.ServiceResponse
import com.example.projectsapi.model.responses.UserResponse
import com.example.projectsapi.model.user.LoginUser
import com.example.projectsapi.model.user.NewUser
import com.example.projectsapi.repository.UserRepository
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

@RestController
@Tag(name = "Authorization API", description = "All about user authorization")
@RequestMapping("/api2/auth/")
class AuthController(
    private val userRepository: UserRepository
) {

    @PostMapping("/signin")
    fun authenticateUser(
        @Valid @RequestBody loginRequest: LoginUser,
        response: HttpServletResponse
    ): ServiceResponse<UserResponse>? {
        val userCandidate: Optional<User> = userRepository.findByEmail(loginRequest.email)

        if (userCandidate.isPresent) {
            val user: User = userCandidate.get()


            return ServiceResponse(
                data = listOf(
                    UserResponse(
                        id = user.id,
                        username = user.username,
                        name = user.name,
                        email = user.email,
                        password = user.password,
                        role = user.role,
                    )
                ),
                status = HttpStatus.OK,
                message = "Auth --done"
            )
        } else {
            return ServiceResponse(
                data = null,
                status = HttpStatus.BAD_REQUEST,
                message = "User not found!"
            )
        }
    }

    @PostMapping("/signup")
    fun registerUser(@Valid @RequestBody newUser: NewUser): ServiceResponse<UserResponse?> {
        val userCandidate: Optional<User> = userRepository.findByUsername(newUser.username!!)

        if (!userCandidate.isPresent) {
            if (usernameExists(newUser.username!!)) {
                return ServiceResponse(
                    data = null,
                    status = HttpStatus.BAD_REQUEST,
                    message = "Username is already taken!"
                )
            } else if (emailExists(newUser.email!!)) {
                return ServiceResponse(
                    data = null,
                    status = HttpStatus.BAD_REQUEST,
                    message = "Email is already in use!"
                )
            }
            var user: User = User()

            try {

                user = User(
                    id = 0,
                    username = newUser.username,
                    name = newUser.name,
                    email = newUser.email,
                    password = newUser.password,
                    role = newUser.role
                )

                userRepository.save(user)

            } catch (e: Exception) {
                return ServiceResponse(
                    data = null,
                    status = HttpStatus.SERVICE_UNAVAILABLE,
                    message = "${e.message}"
                )
            }
            return ServiceResponse(
                data = listOf(UserResponse(
                    id = user.id,
                    username = user.username,
                    name = user.name,
                    email = user.email,
                    password = user.password,
                    role = user.role
                )),
                status = HttpStatus.OK,
                message = "Registration completed!"
            )

        } else {
            return ServiceResponse(
                data = null,
                status = HttpStatus.BAD_REQUEST,
                message = "User already exists!"
            )
        }
    }

    private fun emailExists(email: String): Boolean {
        return userRepository.findByUsername(email).isPresent
    }

    private fun usernameExists(username: String): Boolean {
        return userRepository.findByUsername(username).isPresent
    }

}



























