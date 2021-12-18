package com.tjj.traveldrios2.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.tjj.traveldrios2.databinding.ActivityMainBinding
import com.tjj.traveldrios2.model.Sitio

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val sitio : Sitio = intent.extras?.getSerializable("sitio") as Sitio

        with(mainBinding){
            textViewCundinamarca.text = sitio.nombre1
            textView2Descripcion.text = sitio.descripcion1
            textView5Ubicacion.text = sitio.ubicacion1
            textView3Temperatura.text = sitio.temperatura1
            textView6SitiosR.text = sitio.sitiosrecomendados1
            Picasso.get().load(sitio.urlPicture3).into(imageViewNombre)

        }

    }
}
