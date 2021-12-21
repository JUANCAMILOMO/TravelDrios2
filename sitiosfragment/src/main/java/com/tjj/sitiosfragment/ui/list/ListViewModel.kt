package com.tjj.sitiosfragment.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.tjj.sitiosfragment.dataservice.SitiosRepository
import com.tjj.sitiosfragment.modelos.Sitio
import com.tjj.sitiosfragment.modelos.Sitio1
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var sitiosLoad : MutableLiveData<ArrayList<Sitio>> = MutableLiveData()
    val onSitiosLoaded: LiveData<ArrayList<Sitio>> = sitiosLoad

    private val repository = SitiosRepository()

    fun getSitiosFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            sitiosLoad.postValue(repository.getSitios())
        }
    }

    fun loadMockSuperHeroesFromJson(superHeroesString: InputStream?) {
        val superHeroeString = superHeroesString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        sitiosLoad.value = gson.fromJson(superHeroeString, Sitio1::class.java)
    }
}
