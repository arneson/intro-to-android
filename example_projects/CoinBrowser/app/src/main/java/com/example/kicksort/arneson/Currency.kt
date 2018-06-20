package com.example.kicksort.arneson

import com.google.gson.annotations.SerializedName

/**
 * Created by kicksort on 2017-12-22.
 */


data class Currency (
        @SerializedName("CoinName") val name: String,
        @SerializedName("Id") val id: Int,
        @SerializedName("ImageUrl") val imageUrl: String
)

data class Result (val Data: Map<String,Currency>, val BaseImageUrl: String)