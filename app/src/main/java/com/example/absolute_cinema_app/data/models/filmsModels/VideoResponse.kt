package com.example.absolute_cinema_app.data.models.filmsModels

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("total") val total: Int,
    @SerializedName("items") val items: List<VideoItem>
)

data class VideoItem(
    @SerializedName("url") val url: String,
    @SerializedName("name") val name: String,
    @SerializedName("site") val site: String
)
