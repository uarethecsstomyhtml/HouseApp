package com.example.android.houseapp.ui.photos.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arman.guessmoviebymusic.base.domain.Failure
import com.example.android.houseapp.extension.setError
import com.example.android.houseapp.extension.setLoading
import com.example.android.houseapp.extension.setSuccess
import com.example.android.houseapp.ui.photos.domain.usecase.GetPhotosByAlbumIdUseCase
import timber.log.Timber

class PhotosViewModel(private val getPhotosByAlbumIdUseCase: GetPhotosByAlbumIdUseCase) : ViewModel() {

    private val _photosUi = PhotoUiListMutable().apply {
        setLoading()
    }
    val photosUi: PhotoUiListLive
        get() = _photosUi

    fun loadPhotos(albumId: Long) {
        val params = GetPhotosByAlbumIdUseCase.Params(albumId)
        getPhotosByAlbumIdUseCase.invoke(viewModelScope, params) { it.either(::handleFailure, ::handleSuccess) }
    }

    private fun handleFailure(failure: Failure) {
        Timber.e("handleFailure ${failure.exception}")
        _photosUi.setError(failure.exception)
    }

    private fun handleSuccess(posts: PhotosDTOList) {
        _photosUi.setSuccess(mapToPresentation(posts))
    }

    private fun mapToPresentation(albums: PhotosDTOList): PhotoUiList {
        return albums.map { PhotoUi(it.id, it.title, it.url, it.thumbnailUrl) }
    }
}