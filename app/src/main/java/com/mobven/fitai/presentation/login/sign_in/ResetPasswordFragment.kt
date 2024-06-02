package com.mobven.fitai.presentation.login.sign_in

import com.mobven.fitai.databinding.FragmentResetPasswordBinding
import com.mobven.fitai.presentation.base.BaseFragment

class ResetPasswordFragment : BaseFragment<FragmentResetPasswordBinding>(FragmentResetPasswordBinding::inflate){
    override fun observeUi() {
        passwordFocusListener()
        checkPassword()
    }

    private fun checkPassword(){
        binding.editTextResetPasswordConfirm.setOnFocusChangeListener { _, focused ->
            if (!focused && binding.editTextResetPassword.text != binding.editTextResetPasswordConfirm){
                binding.resetPasswordConfirm.helperText = "Parolalarınız eşleşmiyor."
            }
        }
    }
    private fun passwordFocusListener(){
        binding.editTextResetPassword.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.resetPassword.helperText = validPassword()
            }
        }
    }

    private fun validPassword() : String?{
        val passwordText = binding.editTextResetPassword.text.toString()
        if (passwordText.length < 8){
            return "Şifreniz minimum 8 karakter olmalıdır."
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())){
            return "Şifreniz en az bir adet büyük harf içermelidir"
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())){
            return "Şifreniz en az bir adet küçük harf içermelidir"
        }

        return null
    }
}