package com.example.sontbv.base_mvp_sample.data.db.model

import com.squareup.moshi.Json

data class ProfileImage(
        @Json(name="small") val small: String,
        @Json(name="medium") val medium: String,
        @Json(name="large") val large: String)