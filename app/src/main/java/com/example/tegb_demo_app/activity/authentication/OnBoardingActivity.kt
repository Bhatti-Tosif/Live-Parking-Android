package com.example.tegb_demo_app.activity.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tegb_demo_app.activity.dashBoard.DashBoardMainActivity
import com.example.tegb_demo_app.databinding.ActivityOnBoardingBinding
import com.example.tegb_demo_app.utils.sharedPrefference.prefs

class OnBoardingActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(this)
        binding.btnSignUp.setOnClickListener(this)

        if (prefs.isUserLogin) {
            val intent = Intent(this, DashBoardMainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnLogin.id -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            binding.btnSignUp.id -> {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }
}