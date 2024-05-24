package com.mobven.fitai.home.calendar

import androidx.recyclerview.widget.DiffUtil
import com.mobven.fitai.login.sign_up.model.SignUpSelectorItem

class CalendarItemDiffUtil : DiffUtil.ItemCallback<CalendarItem>() {
    override fun areItemsTheSame(oldItem: CalendarItem, newItem: CalendarItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CalendarItem, newItem: CalendarItem): Boolean {
        return oldItem.date == newItem.date
    }
}