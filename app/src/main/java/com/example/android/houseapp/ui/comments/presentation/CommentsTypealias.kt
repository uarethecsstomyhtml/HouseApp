package com.example.android.houseapp.ui.comments.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arman.guessmoviebymusic.base.domain.BaseUseCase
import com.arman.guessmoviebymusic.base.domain.Either
import com.arman.guessmoviebymusic.base.domain.Failure
import com.example.android.houseapp.ResultState
import com.example.android.houseapp.base.entity.NetworkResponse
import com.example.android.houseapp.ui.comments.domain.usecase.GetCommentsByPostId
import com.example.android.houseapp.ui.comments.entity.CommentDTO

typealias CommentsDTOList = List<CommentDTO>

typealias CommentsDTOListNetworkResponse = NetworkResponse<CommentsDTOList>
typealias BaseGetCommentsByPostUseCase = BaseUseCase<CommentsDTOList, GetCommentsByPostId.Params>
typealias CommentsDTOListEither = Either<Failure, CommentsDTOList>

typealias CommentsUiList = List<CommentUi>
typealias CommentsUiListMutable = MutableLiveData<ResultState<CommentsUiList>>
typealias CommentsUiListLive = LiveData<ResultState<CommentsUiList>>

