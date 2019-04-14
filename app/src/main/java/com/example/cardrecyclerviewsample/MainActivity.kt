package com.example.cardrecyclerviewsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.apply {
            adapter = MainAdapter()
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(SingleCardListDecoration(context, false))
            setHasFixedSize(true)
        }
    }
}
