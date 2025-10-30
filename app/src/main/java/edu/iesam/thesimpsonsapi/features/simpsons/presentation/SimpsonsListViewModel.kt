package edu.iesam.thesimpsonsapi.features.simpsons.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.thesimpsonsapi.features.simpsons.domain.GetAllCharactersUseCase


class SimpsonsListViewModel(private val getAll: GetAllCharactersUseCase): ViewModel() {
}