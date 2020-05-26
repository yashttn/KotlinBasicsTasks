package com.example.jetpackdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_details")
class PostsModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "post_id")
    private val postId = 0

    @ColumnInfo(name = "post_name")
    @SerializedName("name")
    var postName: String? = null

    @ColumnInfo(name = "post_message")
    @SerializedName("message")
    var postMessage: String? = null

    @ColumnInfo(name = "post_profile_image")
    @SerializedName("profileImage")
    var postProfileImage: String? = null
}