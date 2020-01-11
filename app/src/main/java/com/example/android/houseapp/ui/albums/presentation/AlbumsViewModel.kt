package com.example.android.houseapp.ui.albums.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.houseapp.base.domain.Failure
import com.example.android.houseapp.extension.setError
import com.example.android.houseapp.extension.setLoading
import com.example.android.houseapp.extension.setSuccess
import com.example.android.houseapp.ui.albums.domain.usecase.GetAlbumsUseCase
import timber.log.Timber

class AlbumsViewModel(private val getAlbumsUseCase: GetAlbumsUseCase) : ViewModel() {

    private val _albumsUi = AlbumsUiListMutable().apply {
        setLoading()
    }
    val albumsUi: AlbumsUiListLive
        get() = _albumsUi

    private var startIndex = 0L

    fun loadAlbums() {
        Timber.e("loadAlbums")
        val params = GetAlbumsUseCase.Params(startIndex)
        getAlbumsUseCase.invoke(viewModelScope, params) { it.either(::handleFailure, ::handleSuccess) }
    }

    private fun handleFailure(failure: Failure) {
        Timber.e("handleFailure ${failure.exception}")
        _albumsUi.setError(failure.exception)
    }

    private fun handleSuccess(posts: AlbumsDTOList) {
        Timber.e("handleSuccess, posts = $posts")
        startIndex = if (posts.isNotEmpty()) posts.last().id + 1 else startIndex
        _albumsUi.setSuccess(mapToPresentation(posts))
    }

    private fun mapToPresentation(albums: AlbumsDTOList): AlbumsUiList {
        Timber.e("mapToPresentation")
        return albums.map { AlbumUi(id = it.id, title = it.title) }
    }

}