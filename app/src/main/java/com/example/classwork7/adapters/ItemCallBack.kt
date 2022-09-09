package com.example.classwork7.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.classwork7.domain.model.CourseModel

object ItemCallback : DiffUtil.ItemCallback<CourseModel.NewCourse>() {
    override fun areItemsTheSame(
        oldItem: CourseModel.NewCourse,
        newItem: CourseModel.NewCourse,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CourseModel.NewCourse,
        newItem: CourseModel.NewCourse,
    ): Boolean {
        return oldItem == newItem
    }
}