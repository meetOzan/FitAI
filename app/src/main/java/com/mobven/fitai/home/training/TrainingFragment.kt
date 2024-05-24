package com.mobven.fitai.home.training


import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentTrainingBinding



class TrainingFragment : BaseFragment<FragmentTrainingBinding>(FragmentTrainingBinding::inflate) {

    override fun observeUi() {
        with(binding) {

            toolbar.toolbarBack.setOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }

            vpTraining.adapter = TrainingPagerAdapter(requireActivity())
            indicatorTraining.attachTo(vpTraining)
        }
    }


}