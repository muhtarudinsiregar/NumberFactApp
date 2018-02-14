package com.example.ardin.numberfactapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by ardin on 14/02/18.
 */
class ApiBuilder {
    companion object {
        val BASE_URL = "http://numbersapi.com"
    }

    fun call() {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(NumberFactService::class.java)
    }
}