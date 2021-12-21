package com.tjj.sitiosfragment.dataservice

class SitiosRepository {

    suspend fun getSitios() = ApiFactory.retrofit.getSitios()
}