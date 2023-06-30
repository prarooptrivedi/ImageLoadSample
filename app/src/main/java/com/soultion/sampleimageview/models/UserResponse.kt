package com.transsoultion.models

data class UserResponse(
    val token: String,
    val user: List<User>
)