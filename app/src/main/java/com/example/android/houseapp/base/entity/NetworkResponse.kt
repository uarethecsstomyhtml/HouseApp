package com.example.android.houseapp.base.entity


data class NetworkResponse<T> (
    val status: Int?,
    val data: T
)