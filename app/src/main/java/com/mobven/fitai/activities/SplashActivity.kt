package com.mobven.fitai.activities


import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.TypefaceSpan
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.mobven.fitai.R
import com.mobven.fitai.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spannableString = SpannableString(binding.appName.text)

        val regularTypeface = ResourcesCompat.getFont(this, R.font.poppins_regular)
        val boldTypeface = ResourcesCompat.getFont(this, R.font.poppins_semi_bold)

        spannableString.setSpan(
            regularTypeface?.let { TypefaceSpan(it) },
            0,
            3,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannableString.setSpan(
            boldTypeface?.let { TypefaceSpan(it) },
            3,
            spannableString.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.appName.text = spannableString

    }
}


