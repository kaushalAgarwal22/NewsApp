package com.kaushal.newsapptasknovopay.Model

data class NewsResponse(
	val totalResults: Int? = null,
	val articles: List<ArticlesItem?>? = null,
	val status: String? = null
)
