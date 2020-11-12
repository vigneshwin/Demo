/*
*Android assessment from 20021590
**/
package com.demo.demoapp.presenter

import android.util.Log
import com.demo.demoapp.common.CommonInterface
import com.demo.demoapp.common.Contants.Companion.DEMO_REPO
import com.demo.demoapp.common.Contants.Companion.LOG_TAG
import com.demo.demoapp.model.MainActivityModel
import com.demo.demoapp.repo.DataSource.GetCallback
import com.demo.demoapp.repo.remote.RemoteDataSource
import com.demo.demoapp.view.MainActivity
import com.demo.demoapp.view.ViewFragment

class MainActivityPresenter: CommonInterface.Presenter {
    private var LOG_CLASS_TAG = LOG_TAG + "MainActivityPresenter"
    private var mView: MainActivity? = null
    private var mRepository: RemoteDataSource? = null
    private var mViewData: CommonInterface.ViewData? = null

    constructor(_view: MainActivity, repository: RemoteDataSource?, view: ViewFragment) {
        this.mView = _view
        this.mRepository = repository
        this.mViewData = view
        mViewData?.setPresenter(this)
    }

    override fun refreshData() {
        getData()
    }

    override fun getData() {
        mRepository?.getRemoteData(DEMO_REPO, object : GetCallback{

            override fun onSuccess(reponse: MainActivityModel?) {
                mView?.updateViewData(reponse?.mTitle.toString())
                mViewData?.setData(reponse)
            }

            override fun onError(error: String?) {
                error?.let { Log.e(LOG_CLASS_TAG, it) }
                mViewData?.onErrorData(error.toString())
            }
        })
    }
}