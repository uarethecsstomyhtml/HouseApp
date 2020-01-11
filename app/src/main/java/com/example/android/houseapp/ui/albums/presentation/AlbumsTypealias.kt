package com.example.android.houseapp.ui.albums.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.houseapp.base.domain.BaseUseCase
import com.example.android.houseapp.base.domain.Either
import com.example.android.houseapp.base.domain.Failure
import com.example.android.houseapp.ResultState
import com.example.android.houseapp.base.entity.NetworkResponse
import com.example.android.houseapp.ui.albums.domain.usecase.GetAlbumsUseCase
import com.example.android.houseapp.ui.albums.entity.AlbumDTO

typealias AlbumsDTOList = List<AlbumDTO>

typealias AlbumsDTOListNetworkResponse = NetworkResponse<AlbumsDTOList>
typealias BaseGetAlbumsUseCase = BaseUseCase<AlbumsDTOList, GetAlbumsUseCase.Params>
typealias AlbumsDTOListEither = Either<Failure, AlbumsDTOList>

typealias AlbumsUiList = List<AlbumUi>
typealias AlbumsUiListMutable = MutableLiveData<ResultState<AlbumsUiList>>
typealias AlbumsUiListLive = LiveData<ResultState<AlbumsUiList>>
typealias AlbumClickListener = (AlbumUi) -> Unit

