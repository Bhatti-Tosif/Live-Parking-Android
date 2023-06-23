package com.example.tegb_demo_app.model.request

data class LoginRequestModel(
    val email: String,
    val password: String,
    val userType: String
)