package c.gingdev.cursedpuppy.data.models

import com.google.gson.annotations.SerializedName

data class CursedRequestModel(
    @SerializedName("type") val type: String,
    @SerializedName("text") val text: String
)