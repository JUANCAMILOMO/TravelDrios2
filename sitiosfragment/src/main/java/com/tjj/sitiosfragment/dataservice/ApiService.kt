package com.tjj.sitiosfragment.dataservice

import com.tjj.sitiosfragment.modelos.Sitio1
import retrofit2.http.GET

interface ApiService {
    @GET("TravelDrios2/sitios")
    suspend fun getSitios(): Sitio1
}