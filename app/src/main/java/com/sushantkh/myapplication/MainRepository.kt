package com.sushantkh.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sushantkh.model.RemoteData
import com.sushantkh.network.ApiService
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.sushantkh.network.RetrofitService


class MainRepository() {

    private lateinit var apiService: ApiService

    public fun getData(): MutableLiveData<RemoteData> {
        val remoteData: MutableLiveData<RemoteData> = MutableLiveData<RemoteData>()

        apiService = RetrofitService.buildService(ApiService::class.java)

        apiService.getDataFromApi().enqueue(object : Callback<RemoteData?> {
            override fun onResponse(
                call: Call<RemoteData?>?,
                response: Response<RemoteData?>
            ) {
                if (response.isSuccessful) {
                    remoteData.value = response.body()
                }
            }

            override fun onFailure(call: Call<RemoteData?>?, t: Throwable?) {
            }
        })
        return remoteData
    }

}