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
import kotlinx.android.synthetic.main.fragment_eight.*
import kotlinx.android.synthetic.main.fragment_eight.view.*
import kotlinx.android.synthetic.main.fragment_fourth.*
import retrofit2.Call
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EightFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EightFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var layoutManager: LinearLayoutManager
    lateinit var mServiceSource: NewsSourceService
    lateinit var adapter: NewsSourceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view :View =inflater.inflate(R.layout.fragment_eight, container, false)

        mServiceSource=Common.newsSourceService
        layoutManager= LinearLayoutManager(activity)
        view.rvEight.layoutManager=layoutManager
        // Inflate the layout for this fragment

        loadNewsSource()
        return view
    }

    private fun loadNewsSource() {

        mServiceSource.source_uk.enqueue(object : retrofit2.Callback<NewsResponse> {
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
                rvEight.adapter=adapter
            }

        })
    }


}
