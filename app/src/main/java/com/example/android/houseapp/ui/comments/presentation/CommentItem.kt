package com.example.android.houseapp.ui.comments.presentation

import com.example.android.houseapp.R.layout.item_comment
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_comment.*

class CommentItem(private val commentUi: CommentUi) : Item() {

    override fun getLayout() = item_comment

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder) {
            commentEmail.text = commentUi.email
            commentName.text = commentUi.title
            commentDesc.text = commentUi.desc
        }
    }

}