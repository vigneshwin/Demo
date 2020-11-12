/*
*Android assessment from 20021590
**/
package com.demo.demoapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.demo.demoapp.R
import com.demo.demoapp.adapter.CustomListAdapter
import com.demo.demoapp.common.CommonInterface
import com.demo.demoapp.common.Contants
import com.demo.demoapp.model.MainActivityModel

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
class ViewFragment : Fragment(), CommonInterface.ViewData {
    private var LOG_CLASS_TAG = Contants.LOG_TAG + "ViewFragment"
    private lateinit var mList: ListView
    private lateinit var mErrorText: TextView
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout
    private var mAdapter: CustomListAdapter? = null
    private var mPresenter: CommonInterface.Presenter? = null
    private var mReponseBody: MainActivityModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment, container, false)
        mList = v.findViewById(R.id.listView)
        mErrorText = v.findViewById(R.id.errorText)
        mSwipeRefreshLayout = v.findViewById(R.id.pullToRefresh);
        return v
    }

    override fun onResume() {
        super.onResume()
        mPresenter!!.getData()
        mSwipeRefreshLayout.setOnRefreshListener {
            mPresenter!!.getData()
            mSwipeRefreshLayout.isRefreshing = false
        }
    }

    override fun setData(reponseBody: MainActivityModel?) {
        setViewVisibility(true)
        this.mReponseBody = reponseBody
        if (null == mAdapter) {
            mAdapter = CustomListAdapter(activity!!.applicationContext, mReponseBody)
            mList.adapter = mAdapter
        } else {
            mAdapter!!.notifyDataSetChanged()
        }
    }

    override fun onErrorData(errorMessage: String) {
        Log.e(LOG_CLASS_TAG,"errorMessage : "+errorMessage)
        if (null != mAdapter) {
            mAdapter!!.notifyDataSetChanged()
        }
        setViewVisibility(false)
    }

    fun setViewVisibility(status: Boolean){
        if (status){
            mList.visibility = View.VISIBLE
            mErrorText.visibility = View.GONE
        } else {
            mList.visibility = View.GONE
            mErrorText.visibility = View.VISIBLE
        }
    }

    override fun setPresenter(presenter: CommonInterface.Presenter?) {
        this.mPresenter = presenter
    }

    companion object {
        fun newInstance(): ViewFragment {
            return ViewFragment()
        }
    }
}