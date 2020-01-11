package com.example.android.houseapp.ui.posts.domain.usecase

import com.arman.guessmoviebymusic.base.domain.Either
import com.arman.guessmoviebymusic.base.domain.Failure
import com.example.android.houseapp.ui.posts.data.repository.PostsRepository
import com.example.android.houseapp.ui.posts.presentation.BaseGetPostsUseCase
import com.example.android.houseapp.ui.posts.presentation.PostsDTOListEither

class GetPostsUseCase(private val postsRepository: PostsRepository) : BaseGetPostsUseCase() {

    override suspend fun run(params: Params): PostsDTOListEither {
        return try {
            val posts = postsRepository.getPosts(params)
            Either.Right(posts)
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(Failure.FeatureFailure(e))
        }
    }

    data class Params(
        val startIndex: Long
    )

}