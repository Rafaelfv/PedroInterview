package com.pokeapi.pedrointerview.domain.viewModel.BaseViewModel

import androidx.lifecycle.ViewModel
import com.pokeapi.pedrointerview.ChuckApp
import com.pokeapi.pedrointerview.domain.viewModel.CategoryJokeViewModel
import com.pokeapi.pedrointerview.domain.viewModel.categoryViewModel.CategoryViewModel

open class BaseViewModel: ViewModel() {

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is CategoryViewModel -> ChuckApp.component.inject(this)
            is CategoryJokeViewModel -> ChuckApp.component.inject(this)
        }
    }

}