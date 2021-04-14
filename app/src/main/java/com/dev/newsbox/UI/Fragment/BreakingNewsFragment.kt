package com.dev.newsbox.UI.Fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.newsbox.R
import com.dev.newsbox.UI.Activity.NewsActivity
import com.dev.newsbox.UI.adapters.NewsAdapter
import com.dev.newsbox.UI.ui.NewsViewModel
import com.dev.newsbox.UI.util.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    val TAG= "BreakingNewsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as NewsActivity).viewModel
        setupRecyclerView()

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer {response->
            when(response){
                is Resource.Success->{
                    hideProgressBar()
                    response.data?.let {newsResponse ->  
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error->{
                    hideProgressBar()
                    response.message?.let{message->
                        Log.e(TAG, "An Error occured: $message")
                    }
                }
                is Resource.Loading->{
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar(){
        paginationProgressBar.visibility=View.INVISIBLE
    }

    private fun showProgressBar(){
        paginationProgressBar.visibility=View.VISIBLE
    }

    private fun setupRecyclerView(){
        newsAdapter=NewsAdapter()
        rvBreakingNews.apply {
            adapter=newsAdapter
            layoutManager=LinearLayoutManager(activity)
        }
    }
}