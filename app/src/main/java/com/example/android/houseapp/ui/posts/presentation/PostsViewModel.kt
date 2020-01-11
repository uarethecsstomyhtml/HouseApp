package com.example.android.houseapp.ui.posts.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.houseapp.base.domain.Failure
import com.example.android.houseapp.extension.setError
import com.example.android.houseapp.extension.setLoading
import com.example.android.houseapp.extension.setSuccess
import com.example.android.houseapp.ui.posts.domain.usecase.GetPostsUseCase
import timber.log.Timber

class PostsViewModel(private val getPostsUseCase: GetPostsUseCase) : ViewModel() {

    private val _postsUi = PostsUiListMutable().apply {
        setLoading()
    }
    val postsUi: PostsUiListLive
        get() = _postsUi

    private var startIndex = 0L

    fun loadPosts() {
        Timber.e("loadPosts, startIndex = $startIndex")
        val params = GetPostsUseCase.Params(startIndex)
        getPostsUseCase.invoke(viewModelScope, params) { it.either(::handleFailure, ::handleSuccess) }
    }

    private fun handleFailure(failure: Failure) {
        Timber.e("handleFailure ${failure.exception}")
        _postsUi.setError(failure.exception)
    }

    private fun handleSuccess(posts: PostsDTOList) {
        Timber.e("handleSuccess posts = $posts")
        startIndex = if (posts.isNotEmpty()) posts.last().id + 1 else startIndex
        _postsUi.setSuccess(mapToPresentation(posts))
    }

    private fun mapToPresentation(posts: PostsDTOList): PostsUiList {
        Timber.e("mapToPresentation")
        return posts.map { PostUi(id = it.id, title = it.title, desc = it.body) }
    }
}