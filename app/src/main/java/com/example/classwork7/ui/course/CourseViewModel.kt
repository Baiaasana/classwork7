package com.example.classwork7.ui.course

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.classwork7.domain.model.CourseModel
import com.example.classwork7.domain.repository.Repository
import com.example.classwork7.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(
    private val repository: Repository
    ) : ViewModel() {

    private val _factFlow = MutableStateFlow<Resource<CourseModel>>(Resource.loading(null))
    val factFlow = _factFlow.asStateFlow()

    fun getFacts() {
        viewModelScope.launch {
            val data = repository.doNetworkCall()
            data.collect {
                _factFlow.value = it
            }
        }
    }
}