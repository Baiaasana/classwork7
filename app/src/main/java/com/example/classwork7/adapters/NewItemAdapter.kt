package com.example.classwork7.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.classwork7.R
import com.example.classwork7.databinding.NewItemBinding
import com.example.classwork7.domain.model.CourseModel
import com.example.classwork7.utils.Constants

class NewItemAdapter :
    ListAdapter<CourseModel.NewCourse, NewItemAdapter.ItemViewHolder>(ItemCallback) {

    inner class ItemViewHolder(private val binding: NewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind() {
            val item = getItem(adapterPosition)
            val color = Color.parseColor("#${item.mainColor}")
            binding.apply {
                tvTitle.text = item.title
                tvQuestion.text = item.question
                tvDuration.text = "${item.duration} min"
                cvItem.setBackgroundColor(color)
            }
            setImage(item = item)
        }

        private fun setImage(item: CourseModel.NewCourse) {
            when (item.iconType.toString()) {
                Constants.SETTINGS.type -> binding.ivImage.setImageResource(R.drawable.ic_settings)
                Constants.CARD.type -> binding.ivImage.setImageResource(R.drawable.ic_card)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(NewItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind()

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
}