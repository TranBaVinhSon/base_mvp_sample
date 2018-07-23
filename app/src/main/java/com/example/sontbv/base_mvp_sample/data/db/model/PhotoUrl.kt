package com.example.sontbv.base_mvp_sample.data.db.model

import com.squareup.moshi.Json

data class PhotoUrl(
        @Json(name="raw") val raw: String,
        @Json(name="full") val full: String,
        @Json(name="regular") val regular: String
)