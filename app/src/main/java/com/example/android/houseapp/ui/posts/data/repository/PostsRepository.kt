package com.example.android.houseapp.ui.posts.data.repository

import com.example.android.houseapp.ui.posts.domain.usecase.GetPostsUseCase
import com.example.android.houseapp.ui.posts.presentation.PostsDTOList

interface PostsRepository {

    suspend fun getPosts(params: GetPostsUseCase.Params): PostsDTOList
}