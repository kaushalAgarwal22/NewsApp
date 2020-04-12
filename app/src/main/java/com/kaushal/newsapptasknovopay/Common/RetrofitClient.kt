package com.kaushal.newsapptasknovopay.Common

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var retrofit: Retrofit? = null

    fun  getClient(baserUrl : String?):Retrofit
    {

        if(retrofit == null)
        {

           retrofit = Retrofit.Builder().baseUrl(baserUrl).addConverterFactory(GsonConverterFactory.create()).build()

        }
        return retrofit!!

    }
}