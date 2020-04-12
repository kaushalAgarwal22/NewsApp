package com.kaushal.newsapptasknovopay.Adapter.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kaushal.newsapptasknovopay.Interface.ItemClickListener
import kotlinx.android.synthetic.main.inflate_news_layout.view.*

class NewsSourceViewHolder (itemView :View):RecyclerView.ViewHolder(itemView),View.OnClickListener {

    private  lateinit var itemClickListener: ItemClickListener

    var source_title= itemView.tvTitle
    var source_timestamp =itemView.tvDescription

    var source_image = itemView.ivNews

    init {
        itemView.setOnClickListener(this)
    }


    fun setItemClicklistener(itemClickListener: ItemClickListener)
    {
        this.itemClickListener= itemClickListener
    }

    override fun onClick(v: View?) {

        itemClickListener.onClick(v!!,adapterPosition)
    }
}