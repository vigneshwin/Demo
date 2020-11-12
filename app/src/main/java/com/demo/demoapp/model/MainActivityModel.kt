/*
*Android assessment from 20021590
**/
package com.demo.demoapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class MainActivityModel {
    @SerializedName("title")
    @Expose
    lateinit var mTitle:String
    @SerializedName("rows")
    @Expose
    lateinit var mRows:ArrayList<InnerDetailEntity>
}