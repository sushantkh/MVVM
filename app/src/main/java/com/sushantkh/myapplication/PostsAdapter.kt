package com.sushantkh.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sushantkh.model.Data
import com.sushantkh.myapplication.databinding.PostListRowBinding

class PostsAdapter(private val postList: List<Data>) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = PostListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        with(holder)
        {
            with(postList[position])
            {
                binding.tvTitle.text = this.title
                binding.tvBody.text = this.body
            }
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    inner class PostViewHolder(val binding: PostListRowBinding) :
        RecyclerView.ViewHolder(binding.root)

}