package com.dev.newsbox.UI.Fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dev.newsbox.R
import com.dev.newsbox.UI.Activity.NewsActivity
import com.dev.newsbox.UI.ui.NewsViewModel

class ArticleNewsFragment : Fragment(R.layout.fragment_article) {
    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=(activity as NewsActivity).viewModel
    }
}