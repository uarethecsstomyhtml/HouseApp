package com.example.android.houseapp.ui.photos.domain.repository

import com.example.android.houseapp.ui.photos.data.remote.PhotosApi
import com.example.android.houseapp.ui.photos.data.repository.PhotosRepository
import com.example.android.houseapp.ui.photos.domain.usecase.GetPhotosByAlbumIdUseCase
import com.example.android.houseapp.ui.photos.presentation.PhotosDTOList

class DefaultPhotosRepository(private val photosApi: PhotosApi): PhotosRepository {

    override suspend fun getPhotosByAlbumId(params: GetPhotosByAlbumIdUseCase.Params): PhotosDTOList {
        return photosApi.getPhotosByAlbumId(params.postId)
    }

}