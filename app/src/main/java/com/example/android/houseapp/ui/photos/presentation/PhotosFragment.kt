package com.example.android.houseapp.ui.photos.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.android.houseapp.R.layout.fragment_photos
import com.example.android.houseapp.ResultState
import com.example.android.houseapp.ResultState.*
import com.example.android.houseapp.extension.gone
import com.example.android.houseapp.extension.toast
import com.example.android.houseapp.extension.visible
import com.example.android.houseapp.ui.photos.presentation.PhotosFragmentDirections.Companion.actionPhotosFragmentToPhotoDetailsFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.content_loading.*
import kotlinx.android.synthetic.main.fragment_albums.*
import kotlinx.android.synthetic.main.fragment_photos.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class PhotosFragment : Fragment(fragment_photos) {

    private val args: PhotosFragmentArgs by navArgs()
    private val adapter = GroupAdapter<GroupieViewHolder>()
    private val viewModel: PhotosViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRv()
        loadPhotos()
        observeChangePhotos()
    }

    private fun setupRv() {
        Timber.d("setupRv")
        rvPhotos.adapter = adapter
    }

    private fun loadPhotos() {
        Timber.d("loadPhotos")
        viewModel.loadPhotos(args.albumId)
    }

    private fun observeChangePhotos() {
        Timber.d("observeChangePhotos")
        viewModel.photosUi.observe(this, Observer(::onChangePhotos))
    }

    private fun onChangePhotos(response: ResultState<PhotoUiList>) {
        Timber.d("onChangePhotos, response = $response")
        when(response) {
            is Loading -> pbLoading.visible()
            is Success -> onSuccess(response.data)
            is Error -> onError()
        }
    }

    private fun hideLoading() {
        pbLoading.gone()
    }

    private fun onSuccess(photos: PhotoUiList) {
        hideLoading()
        photos.forEach { adapter.add(PhotoItem(it, ::onClickItem)) }
    }

    private fun onError() {
        hideLoading()
        context?.toast()
    }

    private fun onClickItem(photoUi: PhotoUi) {
        val action = actionPhotosFragmentToPhotoDetailsFragment(photoUrl = photoUi.url)
        findNavController().navigate(action)
    }
}