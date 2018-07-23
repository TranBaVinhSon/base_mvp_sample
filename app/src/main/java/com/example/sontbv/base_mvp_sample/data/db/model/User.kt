package com.example.sontbv.base_mvp_sample.data.db.model

import com.squareup.moshi.Json

data class User(
        @Json(name="id") val id: String,
        @Json(name="username") val username: String,
        @Json(name="bio") val bio: String,
        @Json(name="total_likes") val total_likes: Int,
        @Json(name="totalPhotos") val totalPhotos: Int,
        @Json(name="profile_image") val profile_image: ProfileImage)