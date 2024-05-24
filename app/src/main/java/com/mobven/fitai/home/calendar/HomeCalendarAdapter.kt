package com.mobven.fitai.home.calendar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobven.fitai.R
import com.mobven.fitai.databinding.CardHomeCalendarItemBinding

class HomeCalendarAdapter :
    ListAdapter<CalendarItem, HomeCalendarAdapter.ViewHolder>(CalendarItemDiffUtil()) {

    inner class ViewHolder(private val binding: CardHomeCalendarItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CalendarItem) {
            with(binding) {

                binding.tvItemCalendarDayName.text = item.dayName
                binding.tvItemCalendarDayNumber.text = item.date

                calendarItem.setOnClickListener {
                    selectItem(currentList, adapterPosition)
                }

                if (item.isSelected) {
                    calendarItem.setBackgroundResource(R.drawable.bg_calendar_item_grey)
                    tvItemCalendarDayName.setTextColor(
                        ContextCompat.getColor(
                            root.context,
                            R.color.white
                        )
                    )
                    tvItemCalendarDayNumber.setTextColor(
                        ContextCompat.getColor(
                            root.context,
                            R.color.dark_grey_3
                        )
                    )
                    tvItemCalendarDayNumber.typeface =
                        ResourcesCompat.getFont(root.context, R.font.urbanist_bold)
                    tvItemCalendarDayName.typeface =
                        ResourcesCompat.getFont(root.context, R.font.urbanist_bold)
                } else {
                    calendarItem.setBackgroundResource(R.drawable.bg_calendar_item_white)
                    tvItemCalendarDayNumber.setTextColor(
                        ContextCompat.getColor(
                            root.context,
                            R.color.black
                        )
                    )
                    tvItemCalendarDayName.setTextColor(
                        ContextCompat.getColor(
                            root.context,
                            R.color.dark_grey_3
                        )
                    )
                    tvItemCalendarDayNumber.typeface =
                        ResourcesCompat.getFont(root.context, R.font.urbanist_regular)
                    tvItemCalendarDayName.typeface =
                        ResourcesCompat.getFont(root.context, R.font.urbanist_regular)
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun selectItem(items: List<CalendarItem>, position: Int) {
        items.forEachIndexed { index, item ->
            item.isSelected = index == position
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardHomeCalendarItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}