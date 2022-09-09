package com.example.classwork7.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.classwork7.databinding.CurrentItemBinding
import com.example.classwork7.domain.model.CourseModel
import com.example.classwork7.utils.extenssions.Glide

class ActiveItemAdapter :
    ListAdapter<CourseModel.ActiveCourses, ActiveItemAdapter.ItemViewHolder>(ItemCallback) {

    inner class ItemViewHolder(private val binding: CurrentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind() {
            val item: CourseModel.ActiveCourses = getItem(adapterPosition)
            val color = Color.parseColor("#${item.mainColor}")
            binding.apply {
                tvTitle.text = item.title.toString()
                tvTitleLite.text = "Booked for ${item.bookingTime.toString()}"
                tvTitleLite.setTextColor(color)
                piProgress.progress = item.progress!!.toInt()
                piProgress.setIndicatorColor(color)
                tvTitle.setTextColor(color)
                cvItem.setBackgroundColor(color)
                cvItem.background.alpha = item.backgroundColorPercent!!.toInt()
                Glide().setImage(item.image.toString(), binding.ivImage)
                ivImage.setBackgroundColor(color)
                cvImage.setBackgroundColor(color)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(CurrentItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind()

    object ItemCallback : DiffUtil.ItemCallback<CourseModel.ActiveCourses>() {
        override fun areItemsTheSame(
            oldItem: CourseModel.ActiveCourses,
            newItem: CourseModel.ActiveCourses,
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CourseModel.ActiveCourses,
            newItem: CourseModel.ActiveCourses,
        ): Boolean {
            return oldItem == newItem
        }
    }
}
