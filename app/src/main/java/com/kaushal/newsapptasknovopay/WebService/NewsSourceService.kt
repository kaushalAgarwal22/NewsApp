package com.kaushal.newsapptasknovopay.WebService

import com.kaushal.newsapptasknovopay.Model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface NewsSourceService {

   @get: GET("v2/top-headlines?country=in&category=business&apiKey=878cf688409745438b3d762bd463e983")
   val sources : Call<NewsResponse>

   @get: GET("v2/top-headlines?country=in&category=entertainment&apiKey=878cf688409745438b3d762bd463e983")
   val source_enntertainment : Call<NewsResponse>

   @get: GET("v2/top-headlines?country=in&category=health&apiKey=878cf688409745438b3d762bd463e983")
   val source_health : Call<NewsResponse>

   @get: GET("v2/top-headlines?country=in&category=science&apiKey=878cf688409745438b3d762bd463e983")
   val source_science : Call<NewsResponse>

   @get: GET("v2/top-headlines?country=in&category=sports&apiKey=878cf688409745438b3d762bd463e983")
   val source_sports : Call<NewsResponse>

   @get: GET("v2/top-headlines?country=in&category=technology&apiKey=878cf688409745438b3d762bd463e983")
   val source_technology : Call<NewsResponse>

   @get: GET("v2/top-headlines?country=us&apiKey=878cf688409745438b3d762bd463e983")
   val source_usa : Call<NewsResponse>

   @get: GET("v2/top-headlines?country=gb&apiKey=878cf688409745438b3d762bd463e983")
   val source_uk : Call<NewsResponse>

   @get: GET("v2/top-headlines?country=au&apiKey=878cf688409745438b3d762bd463e983")
   val source_australia : Call<NewsResponse>

   @get: GET("v2/top-headlines?country=ca&apiKey=878cf688409745438b3d762bd463e983")
   val source_canada : Call<NewsResponse>

}