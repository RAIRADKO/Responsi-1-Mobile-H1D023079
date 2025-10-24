package com.responsi.h1d023079.footballclub.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeamResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("crest") val crestUrl: String?,
    @SerializedName("founded") val founded: Int?,
    @SerializedName("venue") val venue: String?,
    @SerializedName("coach") val coach: Coach?,
    @SerializedName("squad") val squad: List<Player>?
) : Serializable

data class Coach(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("dateOfBirth") val dateOfBirth: String?,
    @SerializedName("nationality") val nationality: String?
) : Serializable

data class Player(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("position") val position: String?,
    @SerializedName("dateOfBirth") val dateOfBirth: String?,
    @SerializedName("nationality") val nationality: String?
) : Serializable