package com.example.android.houseapp.ui.photos.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.android.houseapp.R.layout.fragment_photo_details
import com.example.android.houseapp.R.layout.fragment_photos
import com.example.android.houseapp.ResultState
import com.example.android.houseapp.ResultState.Error
import com.example.android.houseapp.ResultState.Success
import com.example.android.houseapp.extension.load
import com.example.android.houseapp.extension.toast
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_albums.*
import kotlinx.android.synthetic.main.fragment_photo_details.*
import kotlinx.android.synthetic.main.fragment_photos.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class PhotoDetailsFragment : Fragment(fragment_photo_details) {

    private val args: PhotoDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadPhoto()
    }

    private fun loadPhoto() {
        imgPhoto.load(args.photoUrl)
    }



}