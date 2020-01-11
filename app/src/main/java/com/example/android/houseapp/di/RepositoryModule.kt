package com.example.android.houseapp.di

import com.example.android.houseapp.ui.albums.data.repository.AlbumsRepository
import com.example.android.houseapp.ui.albums.domain.repository.DefaultAlbumsRepository
import com.example.android.houseapp.ui.comments.data.repository.CommentsRepository
import com.example.android.houseapp.ui.comments.domain.repository.DefaultCommentsRepository
import com.example.android.houseapp.ui.photos.data.repository.PhotosRepository
import com.example.android.houseapp.ui.photos.domain.repository.DefaultPhotosRepository
import com.example.android.houseapp.ui.posts.data.repository.PostsRepository
import com.example.android.houseapp.ui.posts.domain.repository.DefaultPostsRepository
import org.koin.dsl.module


val repositoryModule = module {
    factory { DefaultCommentsRepository(commentsApi = get()) as CommentsRepository }
    factory { DefaultPostsRepository(postsApi = get()) as PostsRepository }
    factory { DefaultAlbumsRepository(albumsApi = get()) as AlbumsRepository }
    factory { DefaultPhotosRepository(photosApi = get()) as PhotosRepository }
}

