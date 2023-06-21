package com.example.tegb_demo_app.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tegb_demo_app.baseClass.BaseViewModel
import com.example.tegb_demo_app.model.request.LoginRequestModel
import com.example.tegb_demo_app.model.request.SignUpRequestModel
import com.example.tegb_demo_app.model.response.BaseResponseModel
import com.example.tegb_demo_app.model.response.LoginResponse
import com.example.tegb_demo_app.networkLayer.repository.AuthRepository
import com.example.tegb_demo_app.utils.sharedPrefference.prefs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationViewModel: BaseViewModel() {

    val loginSuccess = MutableLiveData<LoginResponse?>()
    val loginFail = MutableLiveData<String?>()
    val userCreated = MutableLiveData<LoginResponse?>()
    val createUserFail = MutableLiveData<String>()
    fun loginUser(requestModel: LoginRequestModel) {

        AuthRepository.loginUser(requestModel).enqueue(object : Callback<BaseResponseModel<LoginResponse>> {
            override fun onResponse(
                call: Call<BaseResponseModel<LoginResponse>>,
                response: Response<BaseResponseModel<LoginResponse>>
            ) {
                if (response.isSuccessful) {
                    Log.d("API", response.body()?.data.toString())
                    prefs.isUserLogin = true
                    prefs.userAuthKey = response.body()?.data?.authToken
                    prefs.refreshToken = response.body()?.data?.refreshToken
                    loginSuccess.value = response.body()?.data
                } else {
                    Log.d("API", response.body()?.error.toString())
                    loginFail.value = response.body()?.error
                }
            }

            override fun onFailure(call: Call<BaseResponseModel<LoginResponse>>, t: Throwable) {
                Log.d("API", "Error in API")
            }
        })
    }

    fun createUser(signUpRequestModel: SignUpRequestModel) {

        AuthRepository.createUser(signUpRequestModel).enqueue(object : Callback<BaseResponseModel<LoginResponse>> {
            override fun onResponse(
                call: Call<BaseResponseModel<LoginResponse>>,
                response: Response<BaseResponseModel<LoginResponse>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d("API", response.body()?.data.toString())
                    userCreated.value = response.body()?.data
                } else {
                    Log.d("API", "Error in Response ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<BaseResponseModel<LoginResponse>>, t: Throwable) {
                Log.d("API", "Error: in API Calling ${call.request().body()}")
            }

        })
    }
}