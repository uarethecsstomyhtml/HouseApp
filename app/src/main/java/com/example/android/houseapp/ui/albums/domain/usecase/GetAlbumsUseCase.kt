package com.example.android.houseapp.ui.albums.domain.usecase

import com.example.android.houseapp.base.domain.Either
import com.example.android.houseapp.base.domain.Failure
import com.example.android.houseapp.ui.albums.data.repository.AlbumsRepository
import com.example.android.houseapp.ui.albums.presentation.AlbumsDTOListEither
import com.example.android.houseapp.ui.albums.presentation.BaseGetAlbumsUseCase

class GetAlbumsUseCase(private val albumsRepository: AlbumsRepository) : BaseGetAlbumsUseCase() {

    override suspend fun run(params: Params): AlbumsDTOListEither {
        return try {
            val albums = albumsRepository.getAlbums(params)
            Either.Right(albums)
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(Failure.FeatureFailure(e))
        }
    }

    data class Params(
        val startIndex: Long
    )

}