package com.tjj.sitiosfragment.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.tjj.sitiosfragment.databinding.FragmentListaBinding
import com.tjj.sitiosfragment.modelos.Sitio
import com.tjj.sitiosfragment.modelos.Sitio1
import com.tjj.sitiosfragment.ui.main.MainActivity


class listaFragment : Fragment() {

    private lateinit var listaBinding: FragmentListaBinding
    private lateinit var  listViewModel: ListViewModel
    private lateinit var sitiosAdapter: SitiosAdapter
    private lateinit var listaSitios: ArrayList<Sitio>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listaBinding = FragmentListaBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listaBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()

        //     listViewModel.loadMockSuperHeroesFromJson(context?.assets?.open("superheroes.json"))

        listViewModel.getSitiosFromServer()

        listViewModel.onSitiosLoaded.observe(viewLifecycleOwner, { result ->
            onSuperheroesLoadedSubscribe(result)
        })

        sitiosAdapter = SitiosAdapter(listaSitios, onItemClicked = { onSitioClicked(it) } )

        listaBinding.sitiosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosAdapter
            setHasFixedSize(false)
        }
    }

    private fun onSuperheroesLoadedSubscribe(result: ArrayList<Sitio>?) {
        result?.let { listSitios ->
            sitiosAdapter.appendItems(listaSitios)


        }
    }

    private fun onSitioClicked(sitio: Sitio) {
        findNavController().navigate(listaFragmentDirections.actionListaFragmentToDetalleFragment(sitioss = sitio))
    }
}
        /*listaSitios = loadMockSitiosFromJson()
        sitiosAdapter = SitiosAdapter(listaSitios, onItemClicked = {onSitioClicked(it)})

        listaBinding.sitiosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosAdapter
            setHasFixedSize(false)
        }

    }

    private fun onSitioClicked(sitio: Sitio) {
        findNavController().navigate(listaFragmentDirections.actionListaFragmentToDetalleFragment(sitioss = sitio))



    }

    private fun loadMockSitiosFromJson(): ArrayList<Sitio> {

        val sitiosString: String = context?.assets?.open("sitios.json")?.bufferedReader().use{it!!.readText()} //TODO reparar!!
        val gson = Gson()
        val data = gson.fromJson(sitiosString, Sitio1::class.java)
        return data
    }


}*/