package com.example.android.houseapp.ui.comments.data.repository

import com.example.android.houseapp.ui.comments.domain.usecase.GetCommentsByPostId
import com.example.android.houseapp.ui.comments.presentation.CommentsDTOList

interface CommentsRepository {

    suspend fun getCommentsByPostId(params: GetCommentsByPostId.Params): CommentsDTOList
}