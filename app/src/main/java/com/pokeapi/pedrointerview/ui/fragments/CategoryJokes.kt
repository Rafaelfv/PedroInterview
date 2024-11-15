package com.pokeapi.pedrointerview.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.pokeapi.pedrointerview.data.Utils.Constants.Companion.KEY_CATEGORY
import com.pokeapi.pedrointerview.databinding.CategoryJokesBinding
import com.pokeapi.pedrointerview.domain.viewModel.CategoryJokeViewModel
import kotlinx.coroutines.launch

class CategoryJokes : Fragment() {

    private lateinit var binding: CategoryJokesBinding
    private val viewModel: CategoryJokeViewModel by viewModels()
    lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category = arguments?.getString(KEY_CATEGORY) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CategoryJokesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getJokeByCategory(category)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    binding.id.text = state.joke?.id?: ""
                    binding.url.text = state.joke?.url
                    binding.value.text = state.joke?.value?: ""
                }
            }
        }
    }


}