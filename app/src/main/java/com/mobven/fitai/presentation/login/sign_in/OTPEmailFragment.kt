package com.mobven.fitai.presentation.login.sign_in


import android.os.CountDownTimer
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentOtpEmailBinding
import com.mobven.fitai.presentation.base.BaseFragment
import java.util.concurrent.TimeUnit

class OTPEmailFragment : BaseFragment<FragmentOtpEmailBinding>(FragmentOtpEmailBinding::inflate) {
    private lateinit var timer: CountDownTimer
    private var isTimerRunning = false
    private var timeLeftInMillis: Long = 61000
    private var _binding: FragmentOtpEmailBinding? = null
    private lateinit var editTexts: List<EditText>

    override fun observeUi() {
        val filter = InputFilter { source, start, end, _, _, _ ->
            for (i in start until end) {
                if (!Character.isDigit(source[i])) {
                    return@InputFilter ""
                }
            }
            null
        }

        editTexts = listOf(
            binding.etOtpBox,
            binding.etOtpBox2,
            binding.etOtpBox3,
            binding.etOtpBox4
        )

        editTexts.forEach { editText ->
            editText.filters = arrayOf(filter)
            editText.addTextChangedListener(otpTextWatcher)
        }

        binding.tvResendCode.setOnClickListener {
            if (isTimerRunning) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.please_wait_time),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.code_resent),
                    Toast.LENGTH_SHORT
                ).show()
                startTimer()
            }
        }
        editTexts[0].requestFocus()

        startTimer()
    }
    
    private val otpTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            if (s != null && s.length == 1) {
                when (s) {
                    editTexts[0].text -> {
                        editTexts[1].requestFocus()
                        binding.etOtpBox.setBackgroundResource(R.drawable.bg_green_stroke)
                    }

                    editTexts[1].text -> {
                        editTexts[2].requestFocus()
                        binding.etOtpBox2.setBackgroundResource(R.drawable.bg_green_stroke)
                    }

                    editTexts[2].text -> {
                        editTexts[3].requestFocus()
                        binding.etOtpBox3.setBackgroundResource(R.drawable.bg_green_stroke)
                    }

                    editTexts[3].text -> checkPassword()
                }
            }

            if (s?.isEmpty()!!) {
                when (s) {
                    editTexts[3].text -> editTexts[2].requestFocus()
                    editTexts[2].text -> editTexts[1].requestFocus()
                    editTexts[1].text -> editTexts[0].requestFocus()
                    editTexts[0].text -> {
                        changeColor(R.drawable.bg_grey_stroke)
                        binding.tvError.visibility = View.INVISIBLE
                    }


                }
            }
        }
    }

    private fun checkPassword() {
        val enteredOtp = editTexts.joinToString("") { it.text.toString() }
        val actualOtp = getString(R.string._1111)

        if (enteredOtp == actualOtp) {
            Toast.makeText(requireContext(), getString(R.string.login_success), Toast.LENGTH_SHORT).show()
            val color = R.drawable.bg_green_stroke
            changeColor(color)
            findNavController().navigate(R.id.action_OTPFragment_to_resetPasswordFragment)

        } else {
            Toast.makeText(requireContext(), getString(R.string.login_failed), Toast.LENGTH_SHORT).show()
            binding.tvError.visibility = View.VISIBLE
            val color = R.drawable.bg_red_stroke
            changeColor(color)
        }
    }

    private fun startTimer() {
        timer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateTimerText()
            }

            override fun onFinish() {
                isTimerRunning = false
                timeLeftInMillis = 61000
            }
        }.start()
        isTimerRunning = true
    }

    private fun updateTimerText() {
        val minutes = TimeUnit.MILLISECONDS.toMinutes(timeLeftInMillis)
        val seconds = TimeUnit.MILLISECONDS.toSeconds(timeLeftInMillis) -
                TimeUnit.MINUTES.toSeconds(minutes)

        val timeFormatted = String.format("%02d:%02d", minutes, seconds)
        binding.tvTimer.text = timeFormatted
    }

    private fun changeColor(color: Int) {
        editTexts.forEach { editText ->
            editText.setBackgroundResource(color)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        timer.cancel()
    }
}