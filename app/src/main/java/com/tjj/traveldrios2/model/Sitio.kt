package com.tjj.traveldrios2.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Sitio(
    @SerializedName("descripcion1")
    var descripcion1: String,
    @SerializedName("nombre1")
    var nombre1: String,
    @SerializedName("sitiosrecomendados1")
    var sitiosrecomendados1: String,
    @SerializedName("temperatura1")
    var temperatura1: String,
    @SerializedName("ubicacion1")
    var ubicacion1: String,
    @SerializedName("urlPicture1")
    var urlPicture1: String,
    @SerializedName("urlPicture2")
    var urlPicture2: String,
    @SerializedName("urlPicture3")
    var urlPicture3: String
) : Serializable