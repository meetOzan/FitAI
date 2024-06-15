package com.mobven.fitai.presentation.home.screens

import android.os.Handler
import android.os.Looper
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentPlanCreatingBinding

class PlanCreatingFragment :
    BaseFragment<FragmentPlanCreatingBinding>(FragmentPlanCreatingBinding::inflate) {

    override fun observeUi() {
        Handler(Looper.getMainLooper()).postDelayed({
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }, 3000)
    }

}