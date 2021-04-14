package com.dev.newsbox.UI.repository

import com.dev.newsbox.UI.DB.ArticleDataBase
import com.dev.newsbox.UI.api.RetrofitInstance

class NewsRepository(
        val db: ArticleDataBase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
            RetrofitInstance.api.getbreakingNews(countryCode,pageNumber)
}