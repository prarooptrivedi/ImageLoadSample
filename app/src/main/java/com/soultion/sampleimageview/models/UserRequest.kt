package com.transsoultion.models

data class UserRequest(
    val deviceid: String,
    val devicetype: String,
    val password: String,
    val username: String
)