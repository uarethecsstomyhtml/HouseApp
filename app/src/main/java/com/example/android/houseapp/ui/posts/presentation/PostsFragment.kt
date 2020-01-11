package com.example.android.houseapp.ui.posts.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.houseapp.InfiniteScrollListener
import com.example.android.houseapp.R.layout.fragment_posts
import com.example.android.houseapp.ResultState
import com.example.android.houseapp.ResultState.*
import com.example.android.houseapp.extension.gone
import com.example.android.houseapp.extension.toast
import com.example.android.houseapp.extension.visible
import com.example.android.houseapp.ui.posts.presentation.PostsFragmentDirections.Companion.actionNavigationPostsToCommentsFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.content_loading.*
import kotlinx.android.synthetic.main.fragment_posts.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class PostsFragment : Fragment(fragment_posts) {

    private val adapter = GroupAdapter<GroupieViewHolder>()
    private val viewModel: PostsViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRv()
        loadPosts()
        observeChangePosts()
    }

    private fun setupRv() {
        Timber.d("setupRv")
        val layoutManager = rvPosts.layoutManager as LinearLayoutManager
        rvPosts.apply {
            adapter = this@PostsFragment.adapter
            addOnScrollListener(object : InfiniteScrollListener(layoutManager) {
                override fun onLoadMore(current_page: Int) {
                    viewModel.loadPosts()
                }
            })
        }
    }

    private fun loadPosts() {
        Timber.d("loadPosts")
        viewModel.loadPosts()
    }

    private fun observeChangePosts() {
        Timber.d("observeChangePosts")
        viewModel.postsUi.observe(this, Observer(::onChangePosts))
    }

    private fun onChangePosts(response: ResultState<PostsUiList>) {
        Timber.d("onChangePosts")
        when(response) {
            is Loading -> pbLoading.visible()
            is Success -> onSuccess(response.data)
            is Error -> onError()
        }
    }

    private fun hideLoading() {
        pbLoading.gone()
    }

    private fun onSuccess(posts: PostsUiList) {
        hideLoading()
        posts.forEach { adapter.add(PostItem(it, ::onClickItem)) }
    }

    private fun onError() {
        hideLoading()
        context?.toast()
    }

    private fun onClickItem(postUi: PostUi) {
        val action = actionNavigationPostsToCommentsFragment(post= postUi)
        findNavController().navigate(action)
    }
}