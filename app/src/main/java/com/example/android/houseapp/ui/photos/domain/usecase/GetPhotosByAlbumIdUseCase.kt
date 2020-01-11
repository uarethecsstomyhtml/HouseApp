package com.example.android.houseapp.ui.photos.domain.usecase

import com.arman.guessmoviebymusic.base.domain.Either
import com.arman.guessmoviebymusic.base.domain.Failure
import com.example.android.houseapp.ui.albums.data.repository.AlbumsRepository
import com.example.android.houseapp.ui.comments.data.repository.CommentsRepository
import com.example.android.houseapp.ui.comments.presentation.BaseGetCommentsByPostUseCase
import com.example.android.houseapp.ui.comments.presentation.CommentsDTOListEither
import com.example.android.houseapp.ui.photos.data.repository.PhotosRepository
import com.example.android.houseapp.ui.photos.presentation.BaseGetPhotosByAlbumIdUseCase
import com.example.android.houseapp.ui.photos.presentation.PhotosDTOListEither

class GetPhotosByAlbumIdUseCase(
    private val photosRepository: PhotosRepository
) : BaseGetPhotosByAlbumIdUseCase() {


    override suspend fun run(params: Params): PhotosDTOListEither {
        return try {
            val comments = photosRepository.getPhotosByAlbumId(params)
            Either.Right(comments)
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(Failure.FeatureFailure(e))
        }
    }

    data class Params(
        val postId: Long
    )

}