package com.example.jetpackdemo.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.jetpackdemo.PostsModel

class PostsRepository(context: Context) {
    private var postList: LiveData<List<PostsModel?>?>? = null
    private var postDao: PostsDao? = null

    init {
        val postDatabase: PostsDatabase? = PostsDatabase.getInstance(context.applicationContext)
        postDao = postDatabase?.postDao()
        postList = postDao?.allPosts
    }

    fun getPostList(): LiveData<List<PostsModel?>?>? {
        return postList
    }

    fun insertPost(post: PostsModel?) {
        postDao?.insertPost(post)
    }

    fun deleteAllPosts() {
        postDao?.deleteAllPosts()
    }
}
