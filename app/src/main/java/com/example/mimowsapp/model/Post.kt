package com.example.mimowsapp.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("website") val website: String,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String
)
