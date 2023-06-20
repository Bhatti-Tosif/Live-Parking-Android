package com.example.tegb_demo_app.networkLayer.repository

import com.example.tegb_demo_app.model.request.LoginRequestModel
import com.example.tegb_demo_app.model.request.SignUpRequestModel
import com.example.tegb_demo_app.model.response.BaseResponseModel
import com.example.tegb_demo_app.model.response.LoginResponse
import com.example.tegb_demo_app.networkLayer.instance.RetrofitHelper
import retrofit2.Call

object AuthRepository {

    fun loginUser(loginRequestModel: LoginRequestModel): Call<BaseResponseModel<LoginResponse>> {
        return RetrofitHelper.api.loginUser(loginRequestModel)
    }

    fun createUser(signUpRequestModel: SignUpRequestModel): Call<BaseResponseModel<LoginResponse>> {
        return RetrofitHelper.api.createUser(signUpRequestModel)
    }
}