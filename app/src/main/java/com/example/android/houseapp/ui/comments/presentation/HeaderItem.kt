package com.example.android.houseapp.ui.comments.presentation

import com.example.android.houseapp.R.layout.item_header
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_header.*

class HeaderItem(private val titleRes: Int) : Item() {

    override fun getLayout() = item_header

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.headerTitle.setText(titleRes)
    }

}