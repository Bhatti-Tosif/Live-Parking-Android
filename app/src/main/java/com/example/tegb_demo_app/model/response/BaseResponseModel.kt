package com.example.tegb_demo_app.model.response

data class BaseResponseModel<T>(
    var error: String?,
    var message: String?,
    var status: Boolean?,
    var data: T?
)