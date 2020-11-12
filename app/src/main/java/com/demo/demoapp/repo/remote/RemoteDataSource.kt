/*
*Android assessment from 20021590
**/
package com.demo.demoapp.repo.remote

import com.demo.demoapp.common.Contants.Companion.RESPONSE_ERROR_CODE
import com.demo.demoapp.common.Contants.Companion.RESPONSE_SUCESS_CODE
import com.demo.demoapp.model.MainActivityModel
import com.demo.demoapp.repo.DataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RemoteDataSource  // Prevent direct instantiation.
private constructor() : DataSource {

    companion object {
        private var INSTANCE: RemoteDataSource? = null
        val instance: RemoteDataSource?
            get() {
                if (INSTANCE == null) {
                    INSTANCE = RemoteDataSource()
                }
                return INSTANCE
            }
    }

    override fun getRemoteData(value: String?, callback: DataSource.GetCallback?) {
        val getData: ApiClient.GetData = ApiClient.getApiClient().create(ApiClient.GetData::class.java)
        val getDataCall: Call<MainActivityModel> = getData.dataCall
        getDataCall.enqueue(object : Callback<MainActivityModel> {

            override fun onResponse(call: Call<MainActivityModel>, response: Response<MainActivityModel>) {
                if (RESPONSE_SUCESS_CODE == response.code()) {
                    callback!!.onSuccess(response.body())
                } else {
                    callback!!.onError(RESPONSE_ERROR_CODE)
                }
            }

            override fun onFailure(call: Call<MainActivityModel>, t: Throwable) {
                callback!!.onError(t.localizedMessage)
            }
        })
    }
}
