package com.dev.newsbox.UI.ui

import androidx.lifecycle.ViewModel
import com.dev.newsbox.UI.repository.NewsRepository

class NewsViewModel(
        val newsRepository: NewsRepository
): ViewModel() {
}