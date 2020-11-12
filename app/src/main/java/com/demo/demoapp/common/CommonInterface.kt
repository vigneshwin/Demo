/*
*Android assessment from 20021590
**/
package com.demo.demoapp.common

import com.demo.demoapp.model.MainActivityModel

interface CommonInterface {

    interface Presenter {
        fun refreshData()
        fun getData()
    }

    interface View {
        fun updateViewData(title: String)
    }

    interface ViewData : BaseView<Presenter?> {
        fun setData(reponseBody: MainActivityModel?)
        fun onErrorData(errorMessage: String)
    }

    interface BaseView<T> {
        fun setPresenter(presenter: T)
    }
}