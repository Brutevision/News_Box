package com.dev.newsbox.UI.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dev.newsbox.UI.Models.Article

@Database(
        entities = [Article::class],
        version = 1
)

@TypeConverters(Converters::class)

//class should always be abstract for room DB classes
abstract class ArticleDataBase : RoomDatabase() {
    abstract fun getArticleDao() : ArticleDao

    //Companion object to create are DB
    companion object{
        /**
         * writes to this instance will be made visible immediately to other threads.
         * We need to do this so that only one thread is writing to the instance at a time.
         * Otherwise multiple threads will initialise instance variable and multiple instances of same DB will be created.
         * We don't want it here :)
         */
        @Volatile

        private var instance: ArticleDataBase? = null; // First creating an instance of our article DB
        private val LOCK = Any() // This will make sure that there is only a single instance of DB at once.

        /**
         * Called everytime when we create an instance of our DB and it will return our instance.
         * IF our instance is NULL, it will call that synchronized block{} and
         * no other thread can set the instance while code with this block is executing.
         * So in this block{} we again check for nullability->createInstance by calling createDB fun.
         * And set the created result equals to 'it'
         */
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK)
        {
            instance ?: createDatabase(context).also { instance = it }
        }

        //Method to instantiate our DB
        private fun createDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext, ArticleDataBase::class.java, "article_db.db").build()
    }
}