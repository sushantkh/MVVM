package com.sushantkh.network

import com.sushantkh.model.RemoteData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getDataFromApi():Call<RemoteData>
}