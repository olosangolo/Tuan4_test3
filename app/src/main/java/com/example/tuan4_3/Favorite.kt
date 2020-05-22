package com.example.tuan4_3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.khtn.androidcamp.DataCenter
import kotlinx.android.synthetic.main.fragment_now_playing.*
import java.util.ArrayList

class Favorite() : Fragment() {

    lateinit var ACTIVITY: MainActivity
    lateinit var btnList: ImageButton
    lateinit var btnGrid: ImageButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ACTIVITY = context as MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_favourite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = DataCenter.listFavoriteMovie
        btnList = view?.findViewById<ImageButton>(R.id.fav_btn_grid)
        btnGrid = view.findViewById<ImageButton>(R.id.fav_btn_list)

        var layoutManager: LinearLayoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleView!!.layoutManager = layoutManager
        var adapter = context?.let { MovieAdapter(data, it, false) }
        recycleView!!.adapter = adapter

        btnList.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var layoutManager: LinearLayoutManager = LinearLayoutManager(context)
                layoutManager.orientation = LinearLayoutManager.VERTICAL
                recycleView!!.layoutManager = layoutManager
                adapter = context?.let { MovieAdapter(data, it, false) }
                recycleView!!.adapter = adapter
            }
        })
        btnGrid.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var layoutManager: GridLayoutManager = GridLayoutManager(context, 2)
                recycleView!!.layoutManager = layoutManager
                adapter = context?.let { MovieAdapter(data, it, true) }
                recycleView!!.adapter = adapter
            }
        })
    }

}