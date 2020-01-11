package com.example.android.houseapp.ui.comments.data.remote

import com.example.android.houseapp.ui.comments.presentation.CommentsDTOList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CommentsApi {

    @GET("/comments")
    @Headers("Content-Type: application/json")
    suspend fun getCommentsByPostId(@Query("postId") postId: Long): CommentsDTOList
}