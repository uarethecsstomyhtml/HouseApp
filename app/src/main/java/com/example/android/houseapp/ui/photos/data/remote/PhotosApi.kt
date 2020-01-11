package com.example.android.houseapp.ui.photos.data.remote

import com.example.android.houseapp.ui.comments.presentation.CommentsDTOListNetworkResponse
import com.example.android.houseapp.ui.photos.presentation.PhotosDTOList
import com.example.android.houseapp.ui.photos.presentation.PhotosDTOListNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PhotosApi {

    @GET("/photos")
    @Headers("Content-Type: application/json")
    suspend fun getPhotosByAlbumId(@Query("albumId") albumId: Long): PhotosDTOList
}