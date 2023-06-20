package com.example.tegb_demo_app.activity.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tegb_demo_app.R
import com.example.tegb_demo_app.databinding.ActivityLoginBinding
import com.example.tegb_demo_app.viewModel.AuthenticationViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: AuthenticationViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = AuthenticationViewModel()
        binding.btnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id)  {
            binding.btnLogin.id -> {
                //viewModel.loginUser()
            }
        }
    }
}