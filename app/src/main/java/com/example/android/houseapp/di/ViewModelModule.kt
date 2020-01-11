package com.example.android.houseapp.di

import com.example.android.houseapp.ui.albums.presentation.AlbumsViewModel
import com.example.android.houseapp.ui.comments.presentation.CommentsViewModel
import com.example.android.houseapp.ui.photos.presentation.PhotosViewModel
import com.example.android.houseapp.ui.posts.presentation.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PostsViewModel(getPostsUseCase = get()) }
    viewModel { CommentsViewModel(getCommentsByPostIdUseCase = get()) }
    viewModel { AlbumsViewModel(getAlbumsUseCase = get()) }
    viewModel { PhotosViewModel(getPhotosByAlbumIdUseCase = get()) }
}