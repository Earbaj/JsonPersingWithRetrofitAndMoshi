package com.example.openapiperse.data

import com.squareup.moshi.Json

data class JsonData(
    val albumId: Int,
    val id: Int,
    val title: String,
    @Json(name = "url") val img_url: String,
    val thumbnailUrl: String
)