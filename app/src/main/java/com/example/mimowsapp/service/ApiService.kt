package com.example.mimowsapp.service

import com.example.mimowsapp.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getPosts(): Call<List<Post>>
}
