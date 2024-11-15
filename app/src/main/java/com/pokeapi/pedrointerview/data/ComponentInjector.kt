package com.pokeapi.pedrointerview.data

import com.pokeapi.pedrointerview.di.NetworkModule
import com.pokeapi.pedrointerview.domain.viewModel.CategoryJokeViewModel
import com.pokeapi.pedrointerview.domain.viewModel.categoryViewModel.CategoryViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ComponentInjector {
    fun inject(categoryViewModel: CategoryViewModel)
    fun inject(categoryJokeViewModel: CategoryJokeViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ComponentInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }

}