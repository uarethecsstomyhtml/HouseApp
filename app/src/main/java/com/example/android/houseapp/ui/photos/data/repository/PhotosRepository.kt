package com.example.android.houseapp.ui.photos.data.repository

import com.example.android.houseapp.ui.photos.domain.usecase.GetPhotosByAlbumIdUseCase
import com.example.android.houseapp.ui.photos.presentation.PhotosDTOList

interface PhotosRepository {

   suspend fun getPhotosByAlbumId(params: GetPhotosByAlbumIdUseCase.Params): PhotosDTOList
}