package com.example.android.houseapp.ui.posts.presentation

import com.example.android.houseapp.R.layout.item_post
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_post.*

class PostItem(private val postUi: PostUi, private val clickListener: PostClickListener) : Item() {

    override fun getLayout() = item_post

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder) {
            postTitle.text = postUi.title
            postDesc.text = postUi.desc
            itemView.setOnClickListener { clickListener(postUi) }
        }
    }

}