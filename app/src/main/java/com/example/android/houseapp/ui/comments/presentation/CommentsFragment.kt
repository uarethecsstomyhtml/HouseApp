package com.example.android.houseapp.ui.comments.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.android.houseapp.R
import com.example.android.houseapp.R.layout.fragment_comments
import com.example.android.houseapp.R.string.header_comments
import com.example.android.houseapp.ResultState
import com.example.android.houseapp.ResultState.*
import com.example.android.houseapp.extension.gone
import com.example.android.houseapp.extension.toast
import com.example.android.houseapp.extension.visible
import com.example.android.houseapp.ui.photos.presentation.PhotoItem
import com.example.android.houseapp.ui.posts.presentation.PostItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.content_loading.*
import kotlinx.android.synthetic.main.fragment_comments.*
import kotlinx.android.synthetic.main.item_post.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class CommentsFragment : Fragment(fragment_comments) {

    private val args: CommentsFragmentArgs by navArgs()
    private val adapter = GroupAdapter<GroupieViewHolder>()

    private val viewModel: CommentsViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRv()
        setupPost()
        loadCommentsByPostId()
        observeChangeComments()
    }

    private fun setupRv() {
        Timber.d("setupRv")
        adapter.add(HeaderItem(header_comments))
        rvComments.adapter = adapter
    }

    private fun setupPost() {
        with(args.post) {
            postTitle.text = title
            postDesc.text = desc
        }
    }

    private fun loadCommentsByPostId() {
        Timber.d("loadCommentsByPostId")
        viewModel.loadCommentsByPostId(args.post.id)
    }

    private fun observeChangeComments() {
        Timber.d("observeChangeComments")
        viewModel.commentsUi.observe(this, Observer(::onChangeComments))
    }

    private fun onChangeComments(response: ResultState<CommentsUiList>) {
        Timber.d("onChangePosts, response = $response")
        when(response) {
            is Loading -> pbLoading.visible()
            is Success -> onSuccess(response.data)
            is Error -> onError()
        }
    }

    private fun hideLoading() {
        pbLoading.gone()
    }

    private fun onSuccess(comments: CommentsUiList) {
        hideLoading()
        comments.forEach { adapter.add(CommentItem(it)) }
    }

    private fun onError() {
        hideLoading()
        context?.toast()
    }

}