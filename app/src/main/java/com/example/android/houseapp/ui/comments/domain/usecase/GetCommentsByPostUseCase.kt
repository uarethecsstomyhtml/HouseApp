package com.example.android.houseapp.ui.comments.domain.usecase

import com.arman.guessmoviebymusic.base.domain.Either
import com.arman.guessmoviebymusic.base.domain.Failure
import com.example.android.houseapp.ui.comments.data.repository.CommentsRepository
import com.example.android.houseapp.ui.comments.presentation.BaseGetCommentsByPostUseCase
import com.example.android.houseapp.ui.comments.presentation.CommentsDTOListEither

class GetCommentsByPostId(
    private val commentsRepository: CommentsRepository
) : BaseGetCommentsByPostUseCase() {


    override suspend fun run(params: Params): CommentsDTOListEither {
        return try {
            val comments = commentsRepository.getCommentsByPostId(params)
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