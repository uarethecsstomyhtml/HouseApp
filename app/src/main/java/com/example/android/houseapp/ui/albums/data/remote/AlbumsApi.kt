package com.example.android.houseapp.ui.albums.data.remote

import com.example.android.houseapp.ui.albums.presentation.AlbumsDTOList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AlbumsApi {

    @GET("/albums")
    @Headers("Content-Type: application/json")
    suspend fun getAlbums(
        @Query("_start") startIndex: Long,
        @Query("_limit") limit: Int = 20
    ): AlbumsDTOList
}