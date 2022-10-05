package com.example.openapiperse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.openapiperse.data.JsonData
import com.example.openapiperse.databinding.GridListItemBinding

class ListItemAdapter: ListAdapter<JsonData, ListItemAdapter.ListItemViewHolder>(DiffCallBack){

    class ListItemViewHolder(private var bindings: GridListItemBinding): RecyclerView.ViewHolder(bindings.root){
        fun bind(jsonPhoto: JsonData){
            bindings.photos = jsonPhoto

            bindings.executePendingBindings()
        }
    }

    companion object DiffCallBack: DiffUtil.ItemCallback<JsonData>(){
        override fun areItemsTheSame(oldItem: JsonData, newItem: JsonData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: JsonData, newItem: JsonData): Boolean {
            return oldItem.img_url == newItem.img_url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(
            GridListItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val jsonPhoto = getItem(position)
        holder.bind(jsonPhoto)
    }
}