package com.mobven.fitai.home

import android.view.View
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.CardPlanItemBinding
import com.mobven.fitai.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun observeUi() {
        with(binding) {

            setupCards(includeFoodPlanItem,"Kahvaltı",
                "10 dakikada hazır",
                "800 kalori",
                image = R.drawable.food_plan_item)
            includeFoodPlanItem.thirdTv.visibility = View.GONE
            includeFoodPlanItem.thirdIcon.visibility = View.GONE

            setupCards(includeTrainingItem,
                "Evde Fitness",
                "50 dakika",
                "2 Set, 3 Tekrar",
                "400 kalori",
                R.drawable.training_plan_item)

            ivFoodPlanAdd.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_nutritionFragment)
            }

            ivTrainingPlanAdd.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_trainingFragment)
            }


        }


    }
}

private fun setupCards(item : CardPlanItemBinding,
                       header : String ,
                       firstTv : String,
                       secondTv : String,
                       thirdTv : String = "",
                       image : Int){

    item.tvPlanName.text = header
    item.firstTv.text = firstTv
    item.secondTv.text = secondTv
    item.thirdTv.text = thirdTv
    item.ivCircle.setImageResource(image)

}

