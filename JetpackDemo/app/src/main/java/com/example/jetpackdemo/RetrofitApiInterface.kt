package com.example.jetpackdemo

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApiInterface {

    @get:GET("posts.json")
    val posts: Call<PostsListModel?>?
}
