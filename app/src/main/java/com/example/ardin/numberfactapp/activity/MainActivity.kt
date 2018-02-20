package com.example.ardin.numberfactapp.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.ardin.numberfactapp.R
import com.example.ardin.numberfactapp.adapter.NumberFactAdapter
import com.example.ardin.numberfactapp.api.ApiBuilder
import com.example.ardin.numberfactapp.model.NumberFact
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    val api = ApiBuilder().call()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.layoutManager = LinearLayoutManager(this)
        getNumber()
    }

    private fun getNumber() {
        showLoading()
        api.getRandomYear().enqueue(object : Callback<NumberFact> {
            override fun onFailure(call: Call<NumberFact>?, t: Throwable?) {
                showMessageError(t.toString())
            }

            override fun onResponse(call: Call<NumberFact>?, response: Response<NumberFact>?) {
                response?.let {
                    if (it.isSuccessful) {
                        val body = it.body()
                        if (body != null) {
                            hideLoading()
                            list.adapter = NumberFactAdapter(this@MainActivity, body)
                        }
                    }
                }
            }

        })
    }

    fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    fun showMessageError(message: String) {
        hideLoading()
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun hideLoading() {
        progressBar.visibility = View.GONE
    }
}
