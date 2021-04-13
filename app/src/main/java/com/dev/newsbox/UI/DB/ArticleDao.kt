package com.dev.newsbox.UI.DB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dev.newsbox.UI.Models.Article

@Dao
interface ArticleDao {
    //If the article is already present in our DB, then replace
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article) : Long // (This returns the 'Long' which is the id that was inserted)

    @Query("SELECT * FROM articles")
    fun getAllArticles() : LiveData<List<Article>>

    @Delete()
    suspend fun delete(article: Article) //Passing the article which we want to delete and this fun will not return anything.
}