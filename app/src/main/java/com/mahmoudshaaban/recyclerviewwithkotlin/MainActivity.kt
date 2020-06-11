package com.mahmoudshaaban.recyclerviewwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerAdapter: BlogRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()
    }

    private fun initRecyclerView() {
        // this makes me able to the recyclerview wihtout having to actually write the ID explictily
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingItemDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingItemDecoration)
            recyclerAdapter = BlogRecyclerAdapter()
            adapter = recyclerAdapter


        }
/*
        // With out apply method
        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerAdapter = BlogRecyclerAdapter()
        recycler_view.adapter = recyclerAdapter
    }*/
    }

    private fun addDataSet(){
        // we invoke the createDataset to get the list of the data
        val dataSource = DataSource.createDataSet()
        recyclerAdapter.submitList(dataSource)
    }
}
