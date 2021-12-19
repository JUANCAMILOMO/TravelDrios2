package com.tjj.sitiosfragment.datail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.tjj.sitiosfragment.databinding.FragmentDetalleBinding
import com.tjj.sitiosfragment.modelos.Sitio

class DetalleFragment : Fragment() {

    private lateinit var detalleBinding: FragmentDetalleBinding
    private val args: DetalleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detalleBinding = FragmentDetalleBinding.inflate(inflater, container, false)

        return detalleBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sitio = args.sitioss

        with(detalleBinding){
            textViewCundinamarca.text = sitio.nombre1
            textView2Descripcion.text = sitio.descripcion1
            textView5Ubicacion.text = sitio.ubicacion1
            textView3Temperatura.text = sitio.temperatura1
            textView6SitiosR.text = sitio.sitiosrecomendados1
            com.squareup.picasso.Picasso.get().load(sitio.urlPicture3).into(imageViewNombre)

        }
    }

}