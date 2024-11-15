package com.pokeapi.pedrointerview.domain.viewModel

import androidx.lifecycle.viewModelScope
import com.pokeapi.pedrointerview.data.JokeRespose
import com.pokeapi.pedrointerview.data.useCase.CategoryUsecase
import com.pokeapi.pedrointerview.data.useCase.JokeByCategoryUsecase
import com.pokeapi.pedrointerview.domain.viewModel.BaseViewModel.BaseViewModel
import com.pokeapi.pedrointerview.domain.viewModel.categoryViewModel.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryJokeViewModel: BaseViewModel() {

    private val _state = MutableStateFlow(UiStateJoke())
    val state: StateFlow<UiStateJoke> = _state.asStateFlow()

    @Inject
    lateinit var jokeByCategoryUsecase: JokeByCategoryUsecase


    fun getJokeByCategory(cateogory : String) {
        viewModelScope.launch {
            _state.update { it.copy(loading = true) }
            val joke = jokeByCategoryUsecase.getJokesByCategory(cateogory)
            _state.update { it.copy(loading = false) }
            _state.update { it.copy(joke = joke) }
        }
    }



    data class UiStateJoke(val loading: Boolean = false, val joke: JokeRespose? = null)


}