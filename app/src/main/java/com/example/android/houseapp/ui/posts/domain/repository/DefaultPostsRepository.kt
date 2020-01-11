package com.example.android.houseapp.ui.posts.domain.repository

import com.example.android.houseapp.ui.posts.data.remote.PostsApi
import com.example.android.houseapp.ui.posts.data.repository.PostsRepository
import com.example.android.houseapp.ui.posts.domain.usecase.GetPostsUseCase
import com.example.android.houseapp.ui.posts.presentation.PostsDTOList

class DefaultPostsRepository(private val postsApi: PostsApi): PostsRepository {

    override suspend fun getPosts(params: GetPostsUseCase.Params): PostsDTOList {
        return postsApi.getPosts(params.startIndex)
    }

}