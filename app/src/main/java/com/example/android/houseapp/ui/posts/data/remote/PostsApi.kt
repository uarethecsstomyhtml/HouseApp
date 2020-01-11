package com.example.android.houseapp.ui.posts.data.remote

import com.example.android.houseapp.ui.posts.presentation.PostsDTOList
import com.example.android.houseapp.ui.posts.presentation.PostsDTOListNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PostsApi {

    @GET("/posts")
    @Headers("Content-Type: application/json")
    suspend fun getPosts(
        @Query("_start") startIndex: Long,
        @Query("_limit") limit: Int = 20
    ): PostsDTOList
}