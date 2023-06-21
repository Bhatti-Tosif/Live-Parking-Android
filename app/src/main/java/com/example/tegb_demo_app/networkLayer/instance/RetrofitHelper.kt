package com.example.tegb_demo_app.networkLayer.instance

import com.example.tegb_demo_app.networkLayer.api.Api
import com.example.tegb_demo_app.utils.AppConstant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private fun getClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder().addInterceptor(logging).build()
    }

    val api: Api by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
            .create(Api::class.java)
    }

    val serverApi: Api by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstant.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
            .create(Api::class.java)
    }
}