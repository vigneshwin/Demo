/*
*Android assessment from 20021590
**/
package com.demo.demoapp.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import coil.load
import coil.transform.CircleCropTransformation
import com.demo.demoapp.R
import com.demo.demoapp.common.Contants.Companion.HTTP
import com.demo.demoapp.common.Contants.Companion.HTTPS
import com.demo.demoapp.model.MainActivityModel


class CustomListAdapter(context: Context, reponseBody: MainActivityModel?):
    BaseAdapter() {
    private val mLayoutInflater: LayoutInflater
    private val mArrayListDetails: MainActivityModel? = reponseBody
    init {
        this.mLayoutInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return mArrayListDetails!!.mRows.size
    }

    override fun getItem(position: Int): Any {
        return mArrayListDetails!!.mRows.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val rowView = mLayoutInflater.inflate(R.layout.cutomize_list, null, true)
        val titleText = rowView.findViewById(R.id.header) as TextView
        val imageView = rowView.findViewById(R.id.picture) as ImageView
        val descriptionText = rowView.findViewById(R.id.desc) as TextView

        titleText.text = mArrayListDetails?.mRows?.get(position)?.mTitle
        val urlString = Uri.parse(mArrayListDetails?.mRows?.get(position)?.mImageHref.toString().replace(HTTP, HTTPS)
        )
        imageView.load(urlString) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_background)
            transformations(CircleCropTransformation())
        }
        descriptionText.text = mArrayListDetails?.mRows?.get(position)?.mDescription
        return rowView
    }

}
