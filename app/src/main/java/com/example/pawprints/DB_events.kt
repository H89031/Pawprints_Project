package com.example.pawprints

sealed interface DB_events {
    object Signup: DB_events
    data class Save_fullname(val fullname: String): DB_events
    data class Save_username(val username: String): DB_events
    data class Save_email(val email: String): DB_events
    data class Save_bday(val bday: String): DB_events
    data class Save_phonenum(val phonenum: String): DB_events
    data class Save_address(val address: String): DB_events
    data class Save_password(val password: String): DB_events
    object ShowDialog: DB_events
    object HideDialog: DB_events
    data class DeleteUser(val users: Users): DB_events
}