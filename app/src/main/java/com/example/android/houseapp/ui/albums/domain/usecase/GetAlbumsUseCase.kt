package com.example.android.houseapp.ui.albums.domain.usecase

import com.arman.guessmoviebymusic.base.domain.Either
import com.arman.guessmoviebymusic.base.domain.Failure
import com.example.android.houseapp.ui.albums.data.repository.AlbumsRepository
import com.example.android.houseapp.ui.albums.presentation.AlbumsDTOListEither
import com.example.android.houseapp.ui.albums.presentation.BaseGetAlbumsUseCase
import com.example.android.houseapp.ui.posts.data.repository.PostsRepository
import com.example.android.houseapp.ui.posts.presentation.BaseGetPostsUseCase
import com.example.android.houseapp.ui.posts.presentation.PostsDTOListEither

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