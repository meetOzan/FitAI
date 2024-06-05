package com.mobven.fitai.presentation.home.viewmodel

import com.mobven.fitai.util.enums.HomeFragmentType

sealed class HomeAction {
    data class GetSelectorItem(val fragmentType: HomeFragmentType) : HomeAction()

    data object GetCategoryItem : HomeAction()

    data object GetCalendarItem : HomeAction()
}
