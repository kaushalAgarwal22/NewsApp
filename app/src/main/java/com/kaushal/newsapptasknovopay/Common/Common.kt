package com.kaushal.newsapptasknovopay.Common

import com.kaushal.newsapptasknovopay.WebService.NewsSourceService

object  Common {

   val  BASE_URL="https://newsapi.org/"
   val API_KEY= "878cf688409745438b3d762bd463e983"


   val newsSourceService :NewsSourceService get() = RetrofitClient.getClient(BASE_URL).create(NewsSourceService::class.java)

}