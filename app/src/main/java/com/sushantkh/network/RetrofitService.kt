/*
 * Created by BS18270 on 28/09/21, 5:53 PM
 *
 * Copyright (c) 2021 Deere & Company as an unpublished work.
 * All Worldwide Rights Reserved.
 * THIS MATERIAL IS THE PROPERTY OF DEERE & COMPANY.
 * ALL USE, ALTERATIONS, DISCLOSURE, DISSEMINATION
 * AND/OR REPRODUCTION NOT SPECIFICALLY AUTHORIZED
 * BY DEERE & COMPANY IS PROHIBITED.
 *
 */

package com.sushantkh.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object {
        private const val BASE_URL = "https://gorest.co.in/public/v1/"

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        fun <T> buildService(service: Class<T>): T {
            return retrofit.create(service)
        }
    }
}
