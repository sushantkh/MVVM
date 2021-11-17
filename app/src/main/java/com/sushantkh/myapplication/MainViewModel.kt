package com.sushantkh.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sushantkh.model.RemoteData


class MainViewModel : ViewModel() {
    private var mainRepository: MainRepository? = null

    init {
        mainRepository = MainRepository()
    }

    fun getRemoteData(): LiveData<RemoteData> {
        return mainRepository!!.getData()
    }
}