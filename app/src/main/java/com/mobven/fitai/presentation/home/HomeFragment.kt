package com.mobven.fitai.presentation.home

import android.view.View
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.CardPlanItemBinding
import com.mobven.fitai.databinding.FragmentHomeBinding
import com.mobven.fitai.presentation.home.calendar.CalendarItem
import com.mobven.fitai.presentation.home.calendar.HomeCalendarAdapter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

typealias HDirections = HomeFragmentDirections

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val adapter = HomeCalendarAdapter()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun observeUi() {
        with(binding) {

            setupCards(
                includeFoodPlanItem,
                "Kahvaltı",
                "10 dakikada hazır",
                "800 kalori",
                image = R.drawable.food_plan_item
            )
            includeFoodPlanItem.thirdTv.visibility = View.GONE
            includeFoodPlanItem.thirdIcon.visibility = View.GONE

            setupCards(
                includeTrainingItem,
                "Evde Fitness",
                "50 dakika",
                "2 Set, 3 Tekrar",
                "400 kalori",
                R.drawable.training_plan_item
            )

            ivFoodPlanAdd.setOnClickListener {
                val foodAction = com.mobven.fitai.presentation.home.HDirections.actionHomeFragmentToNutritionFragment()
                navigate(foodAction)
            }

            ivTrainingPlanAdd.setOnClickListener {
                val trainingAction = com.mobven.fitai.presentation.home.HDirections.actionHomeFragmentToTrainingFragment()
                navigate(trainingAction)
            }

            ivHomeProfile.setOnClickListener{
                val profileAction = com.mobven.fitai.presentation.home.HDirections.actionHomeFragmentToProfileFragment()
                navigate(profileAction)
            }

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
            binding.rvHomeCalendar.adapter = adapter

        }

    }

    override fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}

private fun setupCards(
    item: CardPlanItemBinding,
    header: String,
    firstTv: String,
    secondTv: String,
    thirdTv: String = "",
    image: Int
) {
    item.tvPlanName.text = header
    item.firstTv.text = firstTv
    item.secondTv.text = secondTv
    item.thirdTv.text = thirdTv
    item.ivCircle.setImageResource(image)
}

