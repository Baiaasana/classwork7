package com.example.classwork7.ui.course

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classwork7.adapters.ActiveItemAdapter
import com.example.classwork7.adapters.NewItemAdapter
import com.example.classwork7.databinding.FragmentCourseBinding
import com.example.classwork7.ui.base.BaseFragment
import com.example.classwork7.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CourseFragment : BaseFragment<FragmentCourseBinding>(FragmentCourseBinding::inflate) {

    private val viewModel: CourseViewModel by viewModels()

    private lateinit var newItemAdapter: NewItemAdapter
    private lateinit var activeItemAdapter: ActiveItemAdapter

    override fun listeners() {
    }

    override fun init() {
        initRecyclers()
        viewModel.getFacts()
    }

    private fun initRecyclers() {
        newItemAdapter = NewItemAdapter()
        activeItemAdapter = ActiveItemAdapter()

        binding.apply {
            rvNewItems.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rvNewItems.adapter = newItemAdapter

            rvActiveItems.layoutManager =
                LinearLayoutManager(context)
            rvActiveItems.adapter = activeItemAdapter

        }
    }

    override fun observers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.factFlow.collect {
                    when (it.status) {
                        Resource.Status.SUCCESS -> {
                            activeItemAdapter.submitList(it.data?.active_courses)
                            newItemAdapter.submitList(it.data?.new_courses)
                        }
                        Resource.Status.ERROR -> {
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()

                        }
                        Resource.Status.LOADING -> {
                            Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}