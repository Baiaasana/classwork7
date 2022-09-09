package com.example.classwork7.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
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
            binding.apply {
                tvTitle.text = item.title
                tvQuestion.text = item.question
                tvDuration.text = "${item.duration} min"
            }
            setImage(item = item)
        }

        private fun setImage(item: CourseModel.NewCourse) {
            when (item.iconType) {
                Constants.SETTINGS.type -> binding.ivImage.setImageResource(R.drawable.ic_settings)
                Constants.CARD.type -> binding.ivImage.setImageResource(R.drawable.ic_card)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        return ItemViewHolder(NewItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.bind()
    }
}