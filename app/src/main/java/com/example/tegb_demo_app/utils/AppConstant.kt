package com.example.tegb_demo_app.utils

object AppConstant {

    const val BASE_URL = "https://staging-auth-api.runparking.com/api/"
    const val login_path = "auth/user/login"
    const val signup_path = "auth/user/signup"

    val commonHeader = mapOf<String, String>(
        "Accept" to "application/json",
        "Authorization" to "accessToken",
        "Content-Type" to "application/json",
        "appversion" to "1.0.1",
        "plateform" to "ios"
    )
}