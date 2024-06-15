package com.mobven.fitai.presentation.home.calendar

import androidx.recyclerview.widget.DiffUtil

class CalendarItemDiffUtil : DiffUtil.ItemCallback<CalendarItem>() {
    override fun areItemsTheSame(oldItem: CalendarItem, newItem: CalendarItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CalendarItem, newItem: CalendarItem): Boolean {
        return oldItem.date == newItem.date
    }
}