package com.example.pawprints

data class UserState(
    val users: List<Users> = emptyList(),
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val userExist: Boolean = false
)