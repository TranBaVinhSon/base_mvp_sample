package com.example.sontbv.base_mvp_sample.data.db.model

import com.squareup.moshi.Json

data class Photo(
        @Json(name="id") val id: String,
        @Json(name="description") val description: String,
        @Json(name="user") val user: User,
        @Json(name="urls") val urls: Urls
)