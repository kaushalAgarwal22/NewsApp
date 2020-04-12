package com.kaushal.newsapptasknovopay.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kaushal.newsapptasknovopay.Adapter.ViewHolder.NewsSourceViewHolder
import com.kaushal.newsapptasknovopay.Interface.ItemClickListener
import com.kaushal.newsapptasknovopay.Model.NewsResponse
import com.kaushal.newsapptasknovopay.NewsDetailActivity
import com.kaushal.newsapptasknovopay.R
import com.squareup.picasso.Picasso

class NewsSourceAdapter(private val context: Context, private val newsResponse: NewsResponse): RecyclerView.Adapter<NewsSourceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsSourceViewHolder {

        val inflater =LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.inflate_news_layout,parent,false)
        return  NewsSourceViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return  newsResponse.articles!!.size
    }

    override fun onBindViewHolder(holder: NewsSourceViewHolder, position: Int) {

        holder.source_title.text = newsResponse.articles!![position]!!.title
        holder.source_timestamp.text = newsResponse.articles!![position]!!.publishedAt

        Picasso.get().load(newsResponse.articles[position]!!.urlToImage).into(holder.source_image);

        holder.setItemClicklistener(object :ItemClickListener

        {
            override fun onClick(view: View, position: Int) {

                val intent = Intent(context,NewsDetailActivity::class.java)
                             intent.putExtra("url",newsResponse.articles!![position]!!.url)
                             context.startActivity(intent)

              //  Toast.makeText(context,"comimg soon",Toast.LENGTH_SHORT).show()
            }

        })

    }
}