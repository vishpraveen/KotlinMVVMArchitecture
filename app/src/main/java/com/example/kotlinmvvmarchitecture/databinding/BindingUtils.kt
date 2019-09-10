package com.example.kotlinmvvmarchitecture.databinding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinmvvmarchitecture.R

object BindingUtils {

    @BindingAdapter("loadImageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, url: String?){
        Glide.with(view.context)
            .load(url)
            .apply { RequestOptions.placeholderOf(R.drawable.ic_placeholder).centerCrop() }
            .into(view)
    }

    @BindingAdapter("setVisibility")
    @JvmStatic
    fun visible(view: View, visibility: Boolean){
        view.visibility = if(visibility){
            View.VISIBLE
        }else{
            View.GONE
        }
    }

    @BindingAdapter("longToString")
    @JvmStatic
    fun convert(view: View, value: Long): String{
        return value.toString()
    }
}