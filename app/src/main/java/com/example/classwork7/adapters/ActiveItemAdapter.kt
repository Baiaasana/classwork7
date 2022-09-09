package com.example.classwork7.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.classwork7.databinding.CurrentItemBinding
import com.example.classwork7.domain.model.CourseModel
import com.example.classwork7.utils.extenssions.Glide

//class ActiveItemAdapter :
//    ListAdapter<CourseModel.ActiveCourses, ActiveItemAdapter.ItemViewHolder>(ItemCallback) {
//
//    inner class ItemViewHolder(private val binding: CurrentItemBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind() {
//            val item = getItem(adapterPosition)
//            binding.apply {
//                tvTitle.text = item.title.toString()
//                tvTitleLite.text = item.title.toString()
//                Glide().setImage(item.image.toString(), binding.ivImage)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//
//        return ItemViewHolder(CurrentItemBinding.inflate(LayoutInflater.from(parent.context),
//            parent,
//            false))
//    }
//
//    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        holder.bind()
//    }
//}