package com.example.android.houseapp.ui.comments.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arman.guessmoviebymusic.base.domain.Failure
import com.example.android.houseapp.extension.setError
import com.example.android.houseapp.extension.setLoading
import com.example.android.houseapp.extension.setSuccess
import com.example.android.houseapp.ui.comments.domain.usecase.GetCommentsByPostId
import timber.log.Timber

class CommentsViewModel(private val getCommentsByPostIdUseCase: GetCommentsByPostId) : ViewModel() {

    private val _commentsUi = CommentsUiListMutable().apply {
        setLoading()
    }
    val commentsUi: CommentsUiListLive
        get() = _commentsUi

    fun loadCommentsByPostId(postId: Long) {
        val params = GetCommentsByPostId.Params(postId)
        getCommentsByPostIdUseCase.invoke(viewModelScope, params) {
            it.either(::handleFailure, ::handleSuccess)
        }
    }

    private fun handleFailure(failure: Failure) {
        Timber.e("handleFailure ${failure.exception}")
        _commentsUi.setError(failure.exception)
    }

    private fun handleSuccess(comments: CommentsDTOList) {
        Timber.e("handleSuccess comments = $comments")
        _commentsUi.setSuccess(data = mapToPresentation(comments))
    }

    private fun mapToPresentation(comments: CommentsDTOList): CommentsUiList {
        Timber.e("mapToPresentation")
        return comments.map { CommentUi(id = it.id, email = it.email, title = it.name, desc = it.body) }
    }
}