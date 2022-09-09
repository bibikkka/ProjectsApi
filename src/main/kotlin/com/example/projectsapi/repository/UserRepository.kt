package com.example.projectsapi.repository

import com.example.projectsapi.jpa.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
@EnableJpaRepositories
interface UserRepository: JpaRepository<User, Long> {


    fun findByUsername(@Param("username") username: String): Optional<User>

    @Query(value = "SELECT u FROM User u where u.email = :email")
    fun findByEmail(@Param("email") email: String): Optional<User>

    fun findAllByRole(role: String): List<User>


}