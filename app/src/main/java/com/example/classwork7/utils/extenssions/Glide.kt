package com.example.classwork7.utils.extenssions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.classwork7.R

class Glide {

    fun setImage(url: String, image: ImageView){
        Glide
            .with(image.context)
            .load(url)
            .placeholder(R.mipmap.ic_launcher)
            .centerCrop()
            .into(image)
    }
}