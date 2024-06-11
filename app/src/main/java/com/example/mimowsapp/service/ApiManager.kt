package com.example.mimowsapp.service

import com.example.mimowsapp.RetrofitClient
import com.example.mimowsapp.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object ApiManager {
    fun getPosts(callback: (List<Post>?, String?) -> Unit) {
        RetrofitClient.instance.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    callback(posts, null)
                } else {
                    callback(null, "Failed to fetch posts")
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                callback(null, t.message)
            }
        })
    }
}
