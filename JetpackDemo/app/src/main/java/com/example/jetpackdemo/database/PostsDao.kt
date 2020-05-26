package com.example.jetpackdemo.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.jetpackdemo.PostsModel

@Dao
interface PostsDao {
    @get:Query("SELECT * FROM user_details")
    val allPosts: LiveData<List<PostsModel?>?>?

    @Insert
    fun insertPost(userModel: PostsModel?)

    @Query("DELETE FROM user_details")
    fun deleteAllPosts()
}
