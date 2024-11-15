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
import com.pokeapi.pedrointerview.R
import com.pokeapi.pedrointerview.data.Utils.Constants.Companion.KEY_CATEGORY
import com.pokeapi.pedrointerview.databinding.CategoryFragmentBinding
import com.pokeapi.pedrointerview.domain.viewModel.categoryViewModel.CategoryViewModel
import com.pokeapi.pedrointerview.ui.adapters.CategoryAdapter
import kotlinx.coroutines.launch

class CategoryFragment: Fragment() {

    private lateinit var binding: CategoryFragmentBinding
    private val viewModel: CategoryViewModel by viewModels()
    private lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CategoryFragmentBinding.inflate(inflater, container, false)
        adapter = CategoryAdapter()
        adapter.onItemClick = { category ->
            goToDetailCategory(category)

        }
        return binding.root
    }

    private fun goToDetailCategory(category: String) {
        val bundle = Bundle()
        bundle.putString(KEY_CATEGORY, category)
        val fragment = CategoryJokes()
        fragment.arguments = bundle
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.add(R.id.content_main, fragment, fragment.javaClass.name)
            .addToBackStack(fragment.javaClass.name)
            .commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        viewModel.getListCategories()

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    binding.progressCircular.visibility = if (state.loading) View.VISIBLE else View.GONE
                    adapter.submitList(state.categories)

                }
            }
        }
    }
}