package com.example.tegb_demo_app.activity.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tegb_demo_app.databinding.ActivitySignUpBinding
import com.example.tegb_demo_app.model.request.SignUpRequestModel
import com.example.tegb_demo_app.viewModel.AuthenticationViewModel

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: AuthenticationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = AuthenticationViewModel()

        viewModel.userCreated.observe(this) {
            Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
        }

        viewModel.createuserFail.observe(this) {
            Toast.makeText(this, "Not Created", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when  (v?.id) {
            binding.btnLogin.id -> {
                val signUpRequest = SignUpRequestModel(binding.etEnterFirstName.text.toString(), binding.etEnterLastName.text.toString(), binding.etEnterEmail.text.toString(), binding.etEnterMobileNumber.text.toString(), binding.etPassword.text.toString())
                viewModel.createUser(signUpRequest)
            }
        }
    }
}