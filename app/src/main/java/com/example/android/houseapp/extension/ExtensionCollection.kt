package com.example.android.houseapp.extension

import android.content.Context
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.android.houseapp.R
import com.example.android.houseapp.R.drawable.photo_placeholder
import com.example.android.houseapp.ResultState


/**
 * ImageView
 */
fun ImageView.load(url: String) {
    Glide.with(this.context).load(url).placeholder(photo_placeholder).into(this)
}

/**
 * MutableLiveData
 */
fun <T> MutableLiveData<ResultState<T>>.setSuccess(data: T) =
    postValue(ResultState.Success(data))

fun <T> MutableLiveData<ResultState<T>>.setLoading() =
    postValue(ResultState.Loading(null))

fun <T> MutableLiveData<ResultState<T>>.setError(e: Throwable, message: T? = null) =
    postValue(ResultState.Error(e, message))

fun <T> MutableLiveData<T>.call() = postValue(null)

fun Context.toast() {
    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
}

fun View.visible() {
    visibility = VISIBLE
}

fun View.gone() {
    visibility = GONE
}

