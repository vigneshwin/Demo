/*
*Android assessment from 20021590
**/
package com.demo.demoapp.repo.remote

import com.demo.demoapp.common.Contants.Companion.request_url
import com.demo.demoapp.model.MainActivityModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

class ApiClient {

    companion object {

        fun getApiClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(request_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    interface GetData {
        @get:Headers("Content-Type: application/json")
        @get:GET("s/2iodh4vg0eortkl/facts.json/")
        val dataCall: Call<MainActivityModel>
    }
}