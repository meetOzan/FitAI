package com.mobven.fitai.presentation.home.personal_plan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobven.fitai.R

class PlanAdapter(private val items: ArrayList<PersonalPlanData>): RecyclerView.Adapter<PlanAdapter.PlanViewHolder>(){
    class PlanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.findViewById(R.id.item_image)
        val name : TextView = itemView.findViewById(R.id.item_name)
        val detail : TextView = itemView.findViewById(R.id.item_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.plan_recycler_item, parent, false)
        return PlanViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        val currentItem = items[position]
        holder.image.setImageResource(currentItem.image)
        holder.name.text = currentItem.name
        holder.detail.text = currentItem.detail
    }

}