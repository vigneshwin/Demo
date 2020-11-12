/*
*Android assessment from 20021590
**/
package com.demo.demoapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.demoapp.R
import com.demo.demoapp.common.ActivityUtils
import com.demo.demoapp.common.CommonInterface
import com.demo.demoapp.presenter.MainActivityPresenter
import com.demo.demoapp.repo.remote.RemoteDataSource

class MainActivity : AppCompatActivity(), CommonInterface.View {
    private lateinit var mPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mViewFragment: ViewFragment = ViewFragment.newInstance()
        // Create the presenter
        mPresenter = MainActivityPresenter(this,RemoteDataSource.instance, mViewFragment)
        ActivityUtils.addFragmentToActivity(supportFragmentManager, mViewFragment, R.id.contentFrame)
    }

    override fun updateViewData(title: String) {
        runOnUiThread {
            supportActionBar!!.title = title
        }
    }
}