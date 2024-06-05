package com.mobven.fitai.presentation.add.training

import android.annotation.SuppressLint
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentAddTrainingBinding
import com.mobven.fitai.presentation.add.adapter.AddItemAdapter
import com.mobven.fitai.presentation.add.viewmodel.AddOnAction
import com.mobven.fitai.presentation.add.viewmodel.AddViewModel
import com.mobven.fitai.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTrainingFragment :
    BaseFragment<FragmentAddTrainingBinding>(FragmentAddTrainingBinding::inflate) {

    private val viewModel: AddViewModel by viewModels()
    private val selectedTrainingAdapter = TrainingAdapter()

    @SuppressLint("NotifyDataSetChanged")
    private val adapter = AddItemAdapter(
        onTrainingItemClicked = { position ->
            val bottomNavigation = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.bottom_sheet_add_training, null)
            bottomNavigation.setContentView(view)

            view.findViewById<ImageView>(R.id.iv_close_time_training).setOnClickListener {
                bottomNavigation.dismiss()
            }
            view.findViewById<Button>(R.id.btn_add_training_time).setOnClickListener {
                val trainingItem = TrainingModel(
                    name = viewModel.uiState.value?.trainingItemList?.get(position)?.title.toString(),
                    image = viewModel.uiState.value?.trainingItemList?.get(position)?.image,
                    description = viewModel.uiState.value?.trainingItemList?.get(position)?.description.toString(),
                    minute = view.findViewById<EditText>(R.id.et_add_training_time).text.toString()
                )
                viewModel.onAction(AddOnAction.AddSelectedTraining(trainingItem))
                selectedTrainingAdapter.submitList(viewModel.uiState.value?.trainingSelectedList)
                selectedTrainingAdapter.notifyDataSetChanged()
                bottomNavigation.dismiss()
            }
            bottomNavigation.show()
        }
    )

    override fun observeUi() {
        with(binding) {
            adapter.submitList(viewModel.uiState.value?.trainingItemList)
            recyclerViewAdd.adapter = adapter

            ivCloseAddTraining.setOnClickListener {
                findNavController().popBackStack()
            }

            cardSelectedAddItems.background = null
            cardSelectedAddItems.cardElevation = 2f

            selectedTrainingAdapter.submitList(viewModel.uiState.value?.trainingSelectedList)
            cardSelectedAiAddItems.rvSelectedTrainingItems.adapter = selectedTrainingAdapter

            val expandableLayout = binding.cardSelectedAiAddItems.llWarningAiPowered

            cardSelectedAddItems.setOnClickListener {
                if (expandableLayout.visibility == ImageView.GONE) {
                    expandableLayout.visibility = View.VISIBLE
                } else {
                    expandableLayout.visibility = View.GONE
                }
            }
        }
    }

    override fun callInitialViewModelFunction() {
        viewModel.onAction(AddOnAction.GetTrainingItems)
    }

}