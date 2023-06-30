package com.cheezycode.notesample.ui.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samplesimage.R
import com.samplesimage.databinding.CustomerlistBinding
import com.soultion.sampleimageview.models.ImagesItem
import com.squareup.picasso.Picasso

class ImageAdapter:
    ListAdapter<ImagesItem, ImageAdapter.NoteViewHolder>(ComparatorDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = CustomerlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NoteViewHolder(binding)
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = getItem(position)

        note?.let {
            holder.bind(it)
        }
    }




    inner class NoteViewHolder(private val binding: CustomerlistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(note: ImagesItem) {

            binding.apply {
               customerAddress.text=note.title
                Picasso.get().load(note.url).placeholder(R.drawable.picasoanim).into(imageView);
            }
        }

    }

    class ComparatorDiffUtil : DiffUtil.ItemCallback<ImagesItem>() {
        override fun areItemsTheSame(oldItem: ImagesItem, newItem: ImagesItem): Boolean {
            return oldItem.id== newItem.id
        }

        override fun areContentsTheSame(oldItem: ImagesItem, newItem: ImagesItem): Boolean {
            return oldItem == newItem
        }
    }
}