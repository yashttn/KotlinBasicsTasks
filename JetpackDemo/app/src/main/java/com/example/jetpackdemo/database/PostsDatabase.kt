package com.example.jetpackdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jetpackdemo.PostsModel

@Database(entities = [PostsModel::class], version = 1)
abstract class PostsDatabase : RoomDatabase() {

    fun postDao(): PostsDao? = null

    companion object {
        var postsDatabaseInstance: PostsDatabase? = null

        val roomCallback: Callback = object : Callback() {}

        fun getInstance(context: Context): PostsDatabase? {
            if (postsDatabaseInstance == null) {
                postsDatabaseInstance = Room.databaseBuilder(
                    context.applicationContext, PostsDatabase::class.java, "user_db"
                )
                    .addCallback(roomCallback)
                    .fallbackToDestructiveMigration().build()
            }
            return postsDatabaseInstance
        }
    }
}