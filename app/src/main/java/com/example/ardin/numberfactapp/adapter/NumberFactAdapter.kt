package com.example.ardin.numberfactapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ardin.numberfactapp.R
import com.example.ardin.numberfactapp.model.NumberFact
import kotlinx.android.synthetic.main.number_fact.view.*

class NumberFactAdapter(val context: Context, var numberFact: NumberFact) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.number_fact, parent, false)
        return Item(view)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as Item).bindData(numberFact)
    }

    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(data: NumberFact) {
            itemView.textNumber.text = "1"
        }
    }
}