package com.example.classwork7.ui.course

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.classwork7.databinding.FragmentCourseBinding
import com.example.classwork7.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseFragment : BaseFragment<FragmentCourseBinding>(FragmentCourseBinding::inflate) {

    private val viewModel: CourseViewModel by viewModels()

    override fun listeners() {
    }

    override fun init() {
    }

    override fun observers() {
    }


}