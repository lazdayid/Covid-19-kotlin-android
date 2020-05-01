package com.lazday.covid_19

import com.google.gson.annotations.SerializedName

data class MainModel (
    @SerializedName("name") val name: String,
    @SerializedName("positif") val positif: String,
    @SerializedName("sembuh") val sembuh: String,
    @SerializedName("meninggal") val meninggal: String
)