package com.example.android.houseapp.ui.photos.presentation

import com.example.android.houseapp.R.layout.item_photo
import com.example.android.houseapp.extension.load
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_photo.*

class PhotoItem(private val photoUi: PhotoUi, private val clickListener: PhotoClickListener) : Item() {

    override fun getLayout() = item_photo

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder) {
            photoImg.load(photoUi.thumbnailUrl)
            itemView.setOnClickListener { clickListener(photoUi) }
        }
    }

}