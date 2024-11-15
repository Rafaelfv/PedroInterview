package com.pokeapi.pedrointerview

import android.app.Application
import com.pokeapi.pedrointerview.data.ComponentInjector
import com.pokeapi.pedrointerview.data.DaggerComponentInjector
import com.pokeapi.pedrointerview.di.NetworkModule

class ChuckApp: Application() {

    companion object {
        lateinit var component: ComponentInjector
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerComponentInjector.builder().networkModule(NetworkModule).build()
    }
}