package com.example.jetpackdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackdemo.databinding.RowRvItemLayoutBinding

class PostsRVAdapter(private var dataSet: List<PostsModel?>?) :
    RecyclerView.Adapter<PostsRVAdapter.PostsViewHolder?>() {

    lateinit var rowRvItemLayoutBinding: RowRvItemLayoutBinding

    fun setDataSet(dataSet: List<PostsModel?>?) {
        this.dataSet = dataSet
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PostsViewHolder {
        rowRvItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.row_rv_item_layout,
            viewGroup,
            false
        )
        return PostsViewHolder(rowRvItemLayoutBinding)
    }

    override fun onBindViewHolder(postsViewHolder: PostsViewHolder, position: Int) {
        val postsModel = dataSet?.get(position)
        rowRvItemLayoutBinding.nameTv.text = postsModel?.postName
        rowRvItemLayoutBinding.messageTv.text = postsModel?.postMessage
    }

    override fun getItemCount(): Int {
        return dataSet?.size ?: 0
    }

    class PostsViewHolder(rowRvItemLayoutBinding: RowRvItemLayoutBinding) :
        RecyclerView.ViewHolder(rowRvItemLayoutBinding.root)

}
