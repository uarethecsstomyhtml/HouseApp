package com.example.android.houseapp.ui.photos.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.houseapp.base.domain.BaseUseCase
import com.example.android.houseapp.base.domain.Either
import com.example.android.houseapp.base.domain.Failure
import com.example.android.houseapp.ResultState
import com.example.android.houseapp.base.entity.NetworkResponse
import com.example.android.houseapp.ui.photos.domain.usecase.GetPhotosByAlbumIdUseCase
import com.example.android.houseapp.ui.photos.entity.PhotoDTO

typealias PhotosDTOList = List<PhotoDTO>

typealias PhotosDTOListNetworkResponse = NetworkResponse<PhotosDTOList>
typealias BaseGetPhotosByAlbumIdUseCase = BaseUseCase<PhotosDTOList, GetPhotosByAlbumIdUseCase.Params>
typealias PhotosDTOListEither = Either<Failure, PhotosDTOList>

typealias PhotoUiList = List<PhotoUi>
typealias PhotoUiListMutable = MutableLiveData<ResultState<List<PhotoUi>>>
typealias PhotoUiListLive = LiveData<ResultState<List<PhotoUi>>>
typealias PhotoClickListener = (PhotoUi) -> Unit

