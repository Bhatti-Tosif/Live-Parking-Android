package com.example.tegb_demo_app.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tegb_demo_app.model.request.LoginRequestModel
import com.example.tegb_demo_app.model.response.BaseResponseModel
import com.example.tegb_demo_app.model.response.LoginResponse
import com.example.tegb_demo_app.networkLayer.repository.AuthRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationViewModel: ViewModel() {

    val loginSuccess = MutableLiveData<LoginResponse?>()
    val loginFail = MutableLiveData<String?>()
    fun loginUser(requestModel: LoginRequestModel) {

        AuthRepository.loginUser(requestModel).enqueue(object : Callback<BaseResponseModel<LoginResponse>> {
            override fun onResponse(
                call: Call<BaseResponseModel<LoginResponse>>,
                response: Response<BaseResponseModel<LoginResponse>>
            ) {
                if (response.isSuccessful) {
                    loginSuccess.value = response.body()?.data
                } else {
                    loginFail.value = response.body()?.error
                }
            }

            override fun onFailure(call: Call<BaseResponseModel<LoginResponse>>, t: Throwable) {
                Log.d("API", "Error in API")
            }
        })
    }
}