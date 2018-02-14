package com.example.ardin.numberfactapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ListAdapter
import com.example.ardin.numberfactapp.R
import com.example.ardin.numberfactapp.adapter.NumberFactAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = NumberFactAdapter(this, 1)
    }
}
