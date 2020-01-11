package com.example.android.houseapp.ui.comments.domain.repository

import com.example.android.houseapp.ui.comments.data.remote.CommentsApi
import com.example.android.houseapp.ui.comments.data.repository.CommentsRepository
import com.example.android.houseapp.ui.comments.domain.usecase.GetCommentsByPostId
import com.example.android.houseapp.ui.comments.presentation.CommentsDTOList

class DefaultCommentsRepository(private val commentsApi: CommentsApi): CommentsRepository {

    override suspend fun getCommentsByPostId(params: GetCommentsByPostId.Params): CommentsDTOList {
        return commentsApi.getCommentsByPostId(params.postId)
    }

}