package edu.iesam.thesimpsonsapi.features.simpsons.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.thesimpsonsapi.R
import edu.iesam.thesimpsonsapi.core.api.ApiClient
import edu.iesam.thesimpsonsapi.features.simpsons.data.SimpsonDataRepository
import edu.iesam.thesimpsonsapi.features.simpsons.data.remote.api.SimpsonsApiRemoteDataSource
import edu.iesam.thesimpsonsapi.features.simpsons.domain.Character
import edu.iesam.thesimpsonsapi.features.simpsons.domain.GetAllCharactersUseCase


class SimpsonsListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_simpsons_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
        viewModel.loadSimpsons()
    }

    private val page = 1
    private val viewModel = SimpsonsListViewModel(
        GetAllCharactersUseCase(
            SimpsonDataRepository(
                SimpsonsApiRemoteDataSource(
                    ApiClient()
                )
            )
            , page
        )
    )

    private fun setUpObserver() {
        val observer = Observer<SimpsonsListViewModel.UiState> { uiState ->
            uiState.error?.let { errorMessage ->
            }
            uiState.characters?.let { characters ->
                setUpRecyclerView(characters)
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun setUpRecyclerView(characters : List<Character>) {
        val adapter = SimpsonsListAdapter(characters)
        val recyclerView: RecyclerView = requireView().findViewById(R.id.rvSimpsonsList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }
}