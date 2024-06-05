package com.mobven.fitai.presentation.login.sign_in.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel
    @Inject
    constructor() : ViewModel() {

    fun validEmail(emailText : String): String? {
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "E-posta adresiniz hatalı!"
        }
        return null
    }

    fun validPhone(phoneText: String): String? {
        if (!Patterns.EMAIL_ADDRESS.matcher(phoneText).matches()) {
            return "Lütfen geçerli bir telefon numarası giriniz!"
        }
        return null
    }

    fun validPassword(passwordText: String) : String?{
        if (passwordText.length < 8){
            return "Şifreniz minimum 8 karakter olmalıdır."
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())){
            return "Şifreniz en az bir adet büyük harf içermelidir"
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())){
            return "Şifreniz en az bir adet küçük harf içermelidir"
        }
        if (!passwordText.matches(".*[1-9].*".toRegex())){
            return "Şifreniz en az bir adet rakam içermelidir"
        }

        return null
    }

    fun isSamePassword(password : String, passwordConfirm : String) : String?{
        return if (password != passwordConfirm){
            "Parolalarınız eşleşmiyor."
        }else{
            null
        }
    }

    fun isEmpty(text : String) : String?{
        return if (text.isEmpty()){
            "Burası boş bırakılamaz."
        }else{
            null
        }
    }

}