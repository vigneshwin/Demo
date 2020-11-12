/*
*Android assessment from 20021590
**/
package com.demo.demoapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class InnerDetailEntity {
    @SerializedName("title")
    @Expose
    var mTitle: String? = null
    @SerializedName("description")
    @Expose
    var mDescription:String? = null
    @SerializedName("imageHref")
    @Expose
    var mImageHref:String? = null
}