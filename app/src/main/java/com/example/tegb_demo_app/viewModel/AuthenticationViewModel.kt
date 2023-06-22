package com.example.tegb_demo_app.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tegb_demo_app.baseClass.BaseViewModel
import com.example.tegb_demo_app.model.request.LoginRequestModel
import com.example.tegb_demo_app.model.response.BaseResponseModel
import com.example.tegb_demo_app.model.response.LoginResponse
import com.example.tegb_demo_app.networkLayer.repository.AuthRepository
import com.example.tegb_demo_app.utils.sharedPrefference.prefs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationViewModel : BaseViewModel() {

    //Live Data Changes
    private val _loginSuccess = MutableLiveData<LoginResponse?>()
    val loginSuccess: LiveData<LoginResponse?>
        get() = _loginSuccess
    private val _loginFail = MutableLiveData<String?>()
    val loginFail: LiveData<String?>
        get() = _loginFail

    //Data changes through XML two way binding handle
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    private var _emailEmpty = MutableLiveData<String>()
    val emailEmpty: LiveData<String>
        get() = _emailEmpty

    private var _passwordEmpty = MutableLiveData<String>()
    val passwordEmpty: LiveData<String>
        get() = _passwordEmpty

    /** When user Click login Button Than Validate User*/
    fun doLogin() {
        if (email.value?.isNotEmpty() == true && password.value?.isNotEmpty() == true) {
            loginUser(LoginRequestModel(email.value!!, password.value!!, "business"))
        } else {
            if (email.value?.isEmpty() == true || email.value == null) {
                _emailEmpty.postValue("")
            } else {
                _passwordEmpty.postValue("")
            }
        }
    }

    /** Api calling for user login  */
    private fun loginUser(requestModel: LoginRequestModel) {

        AuthRepository.loginUser(requestModel)
            .enqueue(object : Callback<BaseResponseModel<LoginResponse>> {
                override fun onResponse(
                    call: Call<BaseResponseModel<LoginResponse>>,
                    response: Response<BaseResponseModel<LoginResponse>>
                ) {
                    if (response.isSuccessful) {
                        Log.d("API", response.body()?.data.toString())
                        prefs.isUserLogin = true
                        prefs.userAuthKey = response.body()?.data?.authToken
                        prefs.refreshToken = response.body()?.data?.refreshToken
                        _loginSuccess.value = response.body()?.data
                    } else {
                        _loginFail.value = response.body()?.message
                    }
                }

                override fun onFailure(call: Call<BaseResponseModel<LoginResponse>>, t: Throwable) {
                    Log.d("API", "Error in API")
                    _loginFail.value = t.message.toString()
                }
            })
    }
}