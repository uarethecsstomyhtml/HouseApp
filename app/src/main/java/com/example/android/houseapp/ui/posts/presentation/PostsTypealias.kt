package com.example.android.houseapp.ui.posts.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.houseapp.base.domain.BaseUseCase
import com.example.android.houseapp.base.domain.Either
import com.example.android.houseapp.base.domain.Failure
import com.example.android.houseapp.ResultState
import com.example.android.houseapp.base.entity.NetworkResponse
import com.example.android.houseapp.ui.posts.domain.usecase.GetPostsUseCase
import com.example.android.houseapp.ui.posts.entity.PostDTO

typealias PostsDTOList = List<PostDTO>
typealias PostsDTOListNetworkResponse = NetworkResponse<PostsDTOList>
typealias BaseGetPostsUseCase = BaseUseCase<PostsDTOList, GetPostsUseCase.Params>
typealias PostsDTOListEither = Either<Failure, PostsDTOList>

typealias PostsUiList = List<PostUi>
typealias PostsUiListMutable = MutableLiveData<ResultState<PostsUiList>>
typealias PostsUiListLive = LiveData<ResultState<PostsUiList>>
typealias PostClickListener = (PostUi) -> Unit

