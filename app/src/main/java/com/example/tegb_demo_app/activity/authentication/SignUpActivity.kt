package com.example.tegb_demo_app.activity.authentication

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tegb_demo_app.R
import com.example.tegb_demo_app.baseClass.BaseActivity
import com.example.tegb_demo_app.databinding.ActivitySignUpBinding
import com.example.tegb_demo_app.viewModel.SignUpViewModel

class SignUpActivity : BaseActivity<ActivitySignUpBinding, SignUpViewModel>() {

    override fun setViewModel(): SignUpViewModel = ViewModelProvider(this)[SignUpViewModel::class.java]

    override fun getResId(): Int = R.layout.activity_sign_up

    override fun setUpView() {
        binding.viewModel = viewModel
        observer()
        binding.btnSignUp.setOnClickListener {
            signUpRequest()
        }
        binding.toolBar.ibRightSide.setOnClickListener {
            finish()
        }
    }

    private fun signUpRequest() {
        viewModel.doSignUp()
    }

    private fun observer() {

        viewModel.userCreated.observe(this) {
            Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
            launchActivity<LoginActivity>()
        }
        viewModel.createUserFail.observe(this) {
            Toast.makeText(this, "Not Created", Toast.LENGTH_SHORT).show()
        }
        viewModel.firstNameEmpty.observe(this) {
            binding.etEnterFirstName.error = getString(R.string.first_name_require)
        }
        viewModel.lastNameEmpty.observe(this) {
            binding.etEnterLastName.error = getString(R.string.last_name_require)
        }
        viewModel.emailEmpty.observe(this) {
            binding.etEnterEmail.error = getString(R.string.email_require)
        }
        viewModel.mobileNumberEmpty.observe(this) {
            binding.etEnterMobileNumber.error = getString(R.string.mobileNumber_require)
        }
        viewModel.passwordEmpty.observe(this) {
            binding.etPassword.error = getString(R.string.password_require)
        }
    }
}