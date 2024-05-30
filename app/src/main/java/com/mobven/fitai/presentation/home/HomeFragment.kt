package com.mobven.fitai.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentHomeBinding
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.presentation.home.calendar.CalendarItem
import com.mobven.fitai.presentation.home.calendar.HomeCalendarAdapter
import com.mobven.fitai.presentation.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.format.DateTimeFormatter

typealias HDirections = HomeFragmentDirections

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val adapter = HomeCalendarAdapter()
    private val homeViewModel: HomeViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun observeUi() {
        homeViewModel.homeUiState.observe(viewLifecycleOwner) { homeState ->
            when {
                homeState.isError -> {
                    handleError(homeState.errorMessage)
                }

                homeState.isLoading -> {
                    handleLoading()
                }

                else -> {
                    handleSuccess()
                }
            }
        }
    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun handleSuccess() {
        with(binding) {
            val dateList = mutableListOf<CalendarItem>()
            val dayFormatter = DateTimeFormatter.ofPattern(getString(R.string.eeee))
            val dateFormatter = DateTimeFormatter.ofPattern(getString(R.string.dd))

            for (i in 0 until 10) {
                val date = LocalDate.now().minusDays(i.toLong())
                val dayName = date.format(dayFormatter).take(3)
                val dateStr = date.format(dateFormatter)
                val isSelected = i == 0
                dateList.add(
                    CalendarItem(
                        date = dateStr,
                        dayName = dayName,
                        isSelected = isSelected
                    )
                )
            }

            adapter.submitList(dateList)
            rvHomeCalendar.adapter = adapter
        }
    }

    private fun handleError(error: String) {
        println(error)
    }

    private fun handleLoading() {
        println(getString(R.string.loading))
    }
}
