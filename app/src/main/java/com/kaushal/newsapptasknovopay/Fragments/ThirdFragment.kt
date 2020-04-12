package com.kaushal.newsapptasknovopay.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaushal.newsapptasknovopay.Adapter.NewsSourceAdapter
import com.kaushal.newsapptasknovopay.Common.Common
import com.kaushal.newsapptasknovopay.Model.NewsResponse

import com.kaushal.newsapptasknovopay.R
import com.kaushal.newsapptasknovopay.WebService.NewsSourceService
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.view.*
import kotlinx.android.synthetic.main.fragment_third.*
import kotlinx.android.synthetic.main.fragment_third.view.*
import retrofit2.Call
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ThirdFragment : Fragment() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var mServiceSource: NewsSourceService
    lateinit var adapter: NewsSourceAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_third,container,false)
        // Inflate t
        // he layout for this fragment

        mServiceSource = Common.newsSourceService
        layoutManager = LinearLayoutManager(activity)
        view.rvThird.layoutManager = layoutManager

        loadNewsSource()
        return view;
    }

    private fun loadNewsSource() {

        mServiceSource.source_health.enqueue(object : retrofit2.Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {

                Log.d("Debug", t.toString())
                Toast.makeText(activity,"Failed", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<NewsResponse>,
                response: Response<NewsResponse>
            ) {
                adapter = context?.let { NewsSourceAdapter(it,response!!.body()!!) }!!
                adapter.notifyDataSetChanged()
                rvThird.adapter=adapter
            }

        })
    }



}
