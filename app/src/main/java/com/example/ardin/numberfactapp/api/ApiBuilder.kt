package com.example.ardin.numberfactapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiBuilder {
    companion object {
        val BASE_URL = "http://numbersapi.com"
    }

    fun call(): NumberFactService {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(NumberFactService::class.java)
    }
}