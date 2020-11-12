/*
*Android assessment from 20021590
**/
package com.demo.demoapp.repo

import com.demo.demoapp.model.MainActivityModel

interface DataSource {
    interface GetCallback {
        fun onSuccess(reponseBody: MainActivityModel?)
        fun onError(st: String?)
    }
    fun getRemoteData(value: String?, callback: GetCallback?)
}