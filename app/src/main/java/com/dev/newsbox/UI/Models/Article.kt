package com.dev.newsbox.UI.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
//Entity will tell studios that this is a table for our dataBase
@Entity(
        tableName = "articles"
)
//table -> Article
//Columns -> all these author, content .. etc
data class Article(
        @PrimaryKey(autoGenerate = true)
        var id: Int ?= null,
        val author: String,
        val content: String,
        val description: String,
        val publishedAt: String,
        val source: Source,   // This is some diff shit:\ So we need to create a typeConverter to tell room that how it should interpret this sources class.
        val title: String,
        val url: String,
        val urlToImage: String
)