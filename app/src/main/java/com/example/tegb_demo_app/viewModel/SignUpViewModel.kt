package com.example.tegb_demo_app.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tegb_demo_app.baseClass.BaseViewModel
import com.example.tegb_demo_app.model.request.SignUpRequestModel
import com.example.tegb_demo_app.model.response.BaseResponseModel
import com.example.tegb_demo_app.model.response.LoginResponse
import com.example.tegb_demo_app.networkLayer.repository.AuthRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : BaseViewModel() {

    private val _userCreated = MutableLiveData<LoginResponse?>()
    val userCreated: LiveData<LoginResponse?>
        get() = _userCreated
    private val _createUserFail = MutableLiveData<String>()
    val createUserFail: LiveData<String>
        get() = _createUserFail

    /** Data Change Through XML Two way binding */
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val mobileNumber = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val firstNameEmpty = MutableLiveData<String>()
    val lastNameEmpty = MutableLiveData<String>()
    val emailEmpty = MutableLiveData<String>()
    val mobileNumberEmpty = MutableLiveData<String>()
    val passwordEmpty = MutableLiveData<String>()

    /** SignUp Validation */
    fun doSignUp() {
        if (firstName.value?.isNotEmpty() == true && lastName.value?.isNotEmpty() == true && email.value?.isNotEmpty() == true && mobileNumber.value?.isNotEmpty() == true && password.value?.isNotEmpty() == true) {
            createUser(
                SignUpRequestModel(
                    firstName.value.toString(),
                    lastName.value.toString(),
                    email.value.toString(),
                    mobileNumber.value.toString(),
                    password.value.toString()
                )
            )
        } else {
            if (firstName.value?.isEmpty() == true || firstName.value == null) {
                firstNameEmpty.postValue("")
            } else if (lastName.value?.isEmpty() == true || lastName.value == null) {
                lastNameEmpty.postValue("")
            } else if (email.value?.isEmpty() == true || email.value == null) {
                emailEmpty.postValue("")
            } else if (mobileNumber.value?.isEmpty() == true || mobileNumber.value == null) {
                mobileNumberEmpty.postValue("")
            } else if (password.value?.isEmpty() == true || password.value == null) {
                passwordEmpty.postValue("")
            }
        }
    }

    /** Api call for signUp User */
    private fun createUser(signUpRequestModel: SignUpRequestModel) {

        AuthRepository.createUser(signUpRequestModel).enqueue(object :
            Callback<BaseResponseModel<LoginResponse>> {
            override fun onResponse(
                call: Call<BaseResponseModel<LoginResponse>>,
                response: Response<BaseResponseModel<LoginResponse>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d("API", response.body()?.data.toString())
                    _userCreated.value = response.body()?.data
                } else {
                    Log.d("API", "Error in Response ${response.errorBody()}")
                    _createUserFail.value = response.body()?.error.toString()
                }
            }

            override fun onFailure(call: Call<BaseResponseModel<LoginResponse>>, t: Throwable) {
                Log.d("API", "Error: in API Calling ${call.request().body()}")
            }

        })
    }
}