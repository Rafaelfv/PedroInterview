package com.pokeapi.pedrointerview.domain.viewModel.categoryViewModel

import androidx.lifecycle.viewModelScope
import com.pokeapi.pedrointerview.data.useCase.CategoryUsecase
import com.pokeapi.pedrointerview.domain.viewModel.BaseViewModel.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryViewModel: BaseViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    @Inject
    lateinit var categoryUsecase: CategoryUsecase

    fun getListCategories() {
        viewModelScope.launch {
            _state.update { it.copy(loading = true) }
            val list = categoryUsecase.getListCategories()
            _state.update { it.copy(loading = false) }
            val listCategories = listOf("one", "two", "three", "four")
            _state.update { it.copy(categories = list) }
        }
    }
}


data class UiState(val loading: Boolean = false, val categories: List<String> = emptyList())