package com.example.android.houseapp.ui.albums.domain.repository

import com.example.android.houseapp.ui.albums.data.remote.AlbumsApi
import com.example.android.houseapp.ui.albums.data.repository.AlbumsRepository
import com.example.android.houseapp.ui.albums.domain.usecase.GetAlbumsUseCase
import com.example.android.houseapp.ui.albums.presentation.AlbumsDTOList

class DefaultAlbumsRepository(private val albumsApi: AlbumsApi): AlbumsRepository {

    override suspend fun getAlbums(params: GetAlbumsUseCase.Params): AlbumsDTOList {
        return albumsApi.getAlbums(params.startIndex)
    }

}