package com.tjj.traveldrios2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListSitioActivity : AppCompatActivity() {

    private lateinit var listSitios: ArrayList<Sitio>
    private lateinit var sitiosAdapter: SitiosAdapter
    private lateinit var sitiosRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_sitio)

        sitiosRecyclerView = findViewById(R.id.sitios_recycler_view)

        listSitios = createMockSitios()
        sitiosAdapter = SitiosAdapter(listSitios)


        sitiosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosAdapter
            setHasFixedSize(false)
        }

    }

    private fun createMockSitios() : ArrayList<Sitio> {
        return arrayListOf(
            Sitio(
                nombre1 = "Cundinamarca",
                descripcion1 = "Cundinamarca es una región central de Colombia en torno a Bogotá, la extensa capital del país que se encuentra a gran altura",
                urlPicture1 = "https://upload.wikimedia.org/wikipedia/commons/a/aa/Mina_de_sal_de_Nemoc%C3%B3n_%2816%29.JPG",
                urlPicture2 = "https://www.entornoturistico.com/wp-content/uploads/2016/04/5-estrellas.jpg"
            ),
            Sitio(
                nombre1 = "Antioquia",
                descripcion1 =  "Es uno de los treinta y dos departamentos que, junto con Bogotá, Distrito Capital, forman la República de Colombia. Su capital es Medellín, la segunda ciudad más poblada del país",
                urlPicture1 = "https://www.aviatur.com/source/contenidos/piedra-penol-guatape.jpg",
                urlPicture2 = "https://www.entornoturistico.com/wp-content/uploads/2016/04/5-estrellas.jpg"


            )

        )
    }
}