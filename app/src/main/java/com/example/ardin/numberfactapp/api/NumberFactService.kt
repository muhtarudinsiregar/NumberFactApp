package com.example.ardin.numberfactapp.api

import com.example.ardin.numberfactapp.model.NumberFact
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by ardin on 14/02/18.
 */
interface NumberFactService {
    @GET("/random/year?json")
    fun getRandomYear(): Call<NumberFact>

    @GET("/random/date?json")
    fun getRandomDate(): Call<NumberFact>

    @GET("/random/math?json")
    fun getRandomMath(): Call<NumberFact>

    @GET("/random/trivia?json")
    fun getRandomTrivia(): Call<NumberFact>

}