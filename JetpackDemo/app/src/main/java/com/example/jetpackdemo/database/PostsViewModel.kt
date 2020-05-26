package com.example.jetpackdemo.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackdemo.PostsModel

class PostsViewModel : ViewModel() {

    private var postsRepository: PostsRepository? = null
    var postList: LiveData<List<PostsModel?>?>? = null
    var context: Context? = null

    init {
        postsRepository = context?.let { PostsRepository(it) }
        postList = postsRepository?.getPostList()
    }

    fun insertPostsVM(postsModel: PostsModel?) {
        postsRepository?.insertPost(postsModel)
    }

    fun deleteAllPostsVM() {
        postsRepository?.deleteAllPosts()
    }
}
