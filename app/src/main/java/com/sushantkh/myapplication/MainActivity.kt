package com.sushantkh.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sushantkh.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mMainViewModel:MainViewModel
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: PostsAdapter
    private lateinit var mRvPosts:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mRvPosts=mBinding.recyclerView
        mRvPosts.setHasFixedSize(true)
        mRvPosts.layoutManager= LinearLayoutManager(applicationContext)

        mMainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mMainViewModel.getRemoteData().observe(this, Observer {
            mAdapter=PostsAdapter(it.data)
            mRvPosts.adapter=mAdapter
        })
    }
}