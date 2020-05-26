package com.example.jetpackdemo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostsListModel {
    @SerializedName("posts")
    @Expose
    var posts: List<PostsModel>? = null
}