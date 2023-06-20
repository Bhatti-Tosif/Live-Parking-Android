package com.example.tegb_demo_app.networkLayer.api

import com.example.tegb_demo_app.model.request.LoginRequestModel
import com.example.tegb_demo_app.model.request.SignUpRequestModel
import com.example.tegb_demo_app.model.response.BaseResponseModel
import com.example.tegb_demo_app.model.response.LoginResponse
import com.example.tegb_demo_app.utils.AppConstant
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface Api {

    @POST(AppConstant.login_path)
    fun loginUser(@Body loginRequestModel: LoginRequestModel, @HeaderMap headers: Map<String, String> = AppConstant.commonHeader): Call<BaseResponseModel<LoginResponse>>

    @POST(AppConstant.signup_path)
    fun createUser(@Body signupRequestModel: SignUpRequestModel, @HeaderMap headers: Map<String, String> = AppConstant.commonHeader): Call<BaseResponseModel<LoginResponse>>
}