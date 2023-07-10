package com.example.tegb_demo_app.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.tegb_demo_app.model.response.BaseResponseModel
import com.example.tegb_demo_app.model.response.ParkingLocationResponseModel
import com.example.tegb_demo_app.networkLayer.repository.AuthRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ParkingLocationViewModel {

    private val parkingLocationResponse = MutableLiveData<ArrayList<ParkingLocationResponseModel>?>()
    val parkingLocationDetail get() = parkingLocationResponse

    fun getParkingLocation() {
           AuthRepository.getParkingLocation().enqueue(object : Callback<BaseResponseModel<ArrayList<ParkingLocationResponseModel>>> {
            override fun onResponse(
                call: Call<BaseResponseModel<ArrayList<ParkingLocationResponseModel>>>,
                response: Response<BaseResponseModel<ArrayList<ParkingLocationResponseModel>>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    parkingLocationResponse.value = response.body()!!.data
                } else {
                    Log.d("API", "Parking Lot Response Null ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(
                call: Call<BaseResponseModel<ArrayList<ParkingLocationResponseModel>>>,
                t: Throwable
            ) {
                Log.d("API", "Error In Parking Lot API")
            }
        })
    }
}