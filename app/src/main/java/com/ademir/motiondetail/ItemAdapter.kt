package com.ademir.motiondetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var dataSet: List<Item> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_item, parent, false)
        )
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bind(dataSet[position])

    fun setData(data: List<Item>) {
        this.dataSet = data
        notifyDataSetChanged()
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item) = with(itemView) {
            // TODO: Bind the data with View
            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}