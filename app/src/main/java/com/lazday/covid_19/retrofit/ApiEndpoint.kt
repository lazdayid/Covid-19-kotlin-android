package com.lazday.covid_19.retrofit

import com.lazday.covid_19.MainModel
import retrofit2.Call
import retrofit2.http.*

interface ApiEndpoint {

    @GET("indonesia")
    fun getData(): Call<List<MainModel>>
}