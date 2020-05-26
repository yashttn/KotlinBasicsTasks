package com.example.jetpackdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackdemo.database.PostsViewModel
import com.example.jetpackdemo.databinding.ActivityMainBinding
import retrofit2.Call

class MainActivity : AppCompatActivity() {

    private var mPostsRecyclerView: RecyclerView? = null
    var mPostsRVAdapter: PostsRVAdapter? = null
    var mPosts: ArrayList<PostsModel>? = null
    private var postsViewModel: PostsViewModel? = null
    private var activityMainBinding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        buildRecyclerView()
        activityMainBinding?.showDataBtn2?.setOnClickListener { putData() }
        activityMainBinding?.addDataBtn2?.setOnClickListener { addData() }
        activityMainBinding?.clearDataBtn2?.setOnClickListener { clearData() }

        postsViewModel = ViewModelProvider(this).get(PostsViewModel::class.java)
        postsViewModel?.context = applicationContext
        postsViewModel?.postList?.observe(this, Observer { data ->
            mPostsRVAdapter?.setDataSet(data)
            mPostsRVAdapter?.notifyDataSetChanged()
        })
    }

    private fun clearData() {
        mPosts?.clear()
        postsViewModel?.deleteAllPostsVM()
        mPostsRVAdapter?.notifyDataSetChanged()
    }

    private fun addData() {
        val post = PostsModel()
        post.postName = "Spider man"
        post.postMessage = "With great power, comes great responsibility"
        post.postProfileImage = ""
        postsViewModel?.insertPostsVM(post)
        mPostsRVAdapter?.notifyDataSetChanged()
    }


    private fun buildRecyclerView() {
        mPostsRecyclerView = findViewById(R.id.recycler_view_2)
        mPostsRecyclerView?.layoutManager = LinearLayoutManager(this)
        mPosts = ArrayList()
        mPosts?.let { mPostsRVAdapter = PostsRVAdapter(it) }
        mPostsRecyclerView?.adapter = mPostsRVAdapter
    }


    private fun putData() {
        val apiInterface: RetrofitApiInterface? =
            RetrofitClientInstance.retrofitInstance?.create(
                RetrofitApiInterface::class.java
            )
        val postsList: Call<PostsListModel?>? = apiInterface?.posts
        postsList?.enqueue(
            RetrofitResponseHandler(
                this@MainActivity,
                object : SuccessAPICallback<PostsListModel?> {
                    override fun onResponse(postsListModel: PostsListModel?) {
                        mPosts = postsListModel?.posts as ArrayList<PostsModel>?
                        mPosts?.let { mPostsRVAdapter?.setDataSet(it) }
                        mPostsRVAdapter?.notifyDataSetChanged()
                    }
                },
                object : FailureAPICallback {
                    override fun onFailure(
                        errorCode: Any?,
                        errorMessage: Any?
                    ) {
                    }
                })
        )
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
