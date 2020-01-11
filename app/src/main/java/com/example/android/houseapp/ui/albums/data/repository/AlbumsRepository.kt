package com.example.android.houseapp.ui.albums.data.repository

import com.example.android.houseapp.ui.albums.domain.usecase.GetAlbumsUseCase
import com.example.android.houseapp.ui.albums.presentation.AlbumsDTOList

interface AlbumsRepository {

    suspend fun getAlbums(params: GetAlbumsUseCase.Params): AlbumsDTOList
}