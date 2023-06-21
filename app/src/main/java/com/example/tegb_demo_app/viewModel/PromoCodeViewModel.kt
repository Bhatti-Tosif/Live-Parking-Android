package com.example.tegb_demo_app.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tegb_demo_app.model.response.BaseResponseModel
import com.example.tegb_demo_app.model.response.PromoCodeResponseModel
import com.example.tegb_demo_app.networkLayer.repository.AuthRepository
import retrofit2.Call
import retrofit2.Response

class PromoCodeViewModel {

    private val promoCodeResponse = MutableLiveData<ArrayList<PromoCodeResponseModel>?>()
    val promoCodeDetail get() = promoCodeResponse


    fun getPromoCode() {
        AuthRepository.grtPromoCode().enqueue(object : retrofit2.Callback<BaseResponseModel<ArrayList<PromoCodeResponseModel>>> {
            override fun onResponse(
                call: Call<BaseResponseModel<ArrayList<PromoCodeResponseModel>>>,
                response: Response<BaseResponseModel<ArrayList<PromoCodeResponseModel>>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    promoCodeResponse.value = response.body()!!.data
                } else {
                    Log.d("API", "PromoCode Response Null")
                }
            }

            override fun onFailure(
                call: Call<BaseResponseModel<ArrayList<PromoCodeResponseModel>>>,
                t: Throwable
            ) {
                Log.d("API", "Error In PromoCode API")
            }
        })
    }
}