package com.transsoultion.models

data class User(
    val created: String,
    val id: Int,
    val isactive: Int,
    val modified: Any,
    val name: String,
    val usergroup: String
)