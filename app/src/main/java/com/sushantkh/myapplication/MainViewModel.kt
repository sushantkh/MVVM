package com.sushantkh.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sushantkh.model.RemoteData


class MainViewModel : ViewModel() {
    private var mainRepository: MainRepository? = null
    lateinit var posts:LiveData<RemoteData>
    init {
        mainRepository = MainRepository()
        posts=MutableLiveData()
    }

    fun getRemoteData(): LiveData<RemoteData> {
        posts= mainRepository!!.getData()
        return posts
    }
}