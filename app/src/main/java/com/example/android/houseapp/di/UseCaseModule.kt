package com.example.android.houseapp.di

import com.example.android.houseapp.ui.albums.domain.usecase.GetAlbumsUseCase
import com.example.android.houseapp.ui.comments.domain.usecase.GetCommentsByPostId
import com.example.android.houseapp.ui.photos.domain.usecase.GetPhotosByAlbumIdUseCase
import com.example.android.houseapp.ui.posts.domain.usecase.GetPostsUseCase
import org.koin.dsl.module


val useCaseModule = module {
    factory { GetCommentsByPostId(commentsRepository = get()) }
    factory { GetPostsUseCase(postsRepository = get()) }
    factory { GetAlbumsUseCase(albumsRepository = get()) }
    factory { GetPhotosByAlbumIdUseCase(photosRepository = get()) }
}

