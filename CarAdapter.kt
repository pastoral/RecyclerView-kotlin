package com.example.newrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_view.view.*

class CarAdapter(var clickListner: OnCarItemClickListner)
    : ListAdapter<Cars,CarViewHolder>(CarDiffCallBack()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        lateinit var carViewHolder : CarViewHolder
        carViewHolder = CarViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view,parent,false ))
        return carViewHolder
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
//        holder.carName?.text =  items.get(position).name
//        holder.carDescription?.text = items.get(position).description
//        holder.carLogo.setImageResource(items.get(position).logo)
        holder.initialize(getItem(position),clickListner) //,clickListner

    }
}

class CarViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
    var carName = itemView.carname
    var carDescription = itemView.cardescription
    var carLogo = itemView.carlogo

    fun initialize(item: Cars, action:OnCarItemClickListner){ //, action:OnCarItemClickListner
        carName.text = item.name
        carDescription.text = item.description
        carLogo.setImageResource(item.logo)

        itemView.setOnClickListener{
            action.onItemClick(item,adapterPosition)
        }

    }

}

interface OnCarItemClickListner{
    fun onItemClick(item: Cars, position: Int)
}

class CarDiffCallBack:DiffUtil.ItemCallback<Cars>(){
    override fun areItemsTheSame(oldItem: Cars, newItem: Cars): Boolean {
        return oldItem.name === newItem.name
    }

    override fun areContentsTheSame(oldItem: Cars, newItem: Cars): Boolean {
        return oldItem == newItem
    }
}