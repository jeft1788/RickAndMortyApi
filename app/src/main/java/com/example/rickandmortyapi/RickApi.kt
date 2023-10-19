package com.example.rickandmortyapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RickApi {
    @GET("character")
    fun getDetails() : Call<RickMorty>


}