package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class HelloController(private val userRepository: UserRepository) {

    @GetMapping("/")
    fun hello(): String {
        return "Hello, Spring Boot!"
    }

    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user: User): User {
        return userRepository.save(user)
    }

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: Long): User? {
        return userRepository.findById(id).orElse(null)
    }
}

//@RestController
//class HelloController {
//
//    @GetMapping("/")
//    fun hello(): String {
//        return "Hello, Spring Boot!"
//    }
//
//    @GetMapping("/api/users")
//    fun getUsers(): List<String> {
//        return listOf("사용자1", "사용자2", "사용자3")
//    }
//}