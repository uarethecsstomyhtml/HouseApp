package com.example.android.houseapp.ui.posts.presentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostUi(
    val id : Long,
    val title : String,
    val desc : String
): Parcelable