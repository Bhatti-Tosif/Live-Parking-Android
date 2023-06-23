package com.example.tegb_demo_app.activity.authentication

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModelProvider
import com.example.tegb_demo_app.R
import com.example.tegb_demo_app.baseClass.BaseActivity
import com.example.tegb_demo_app.databinding.ActivitySignUpBinding
import com.example.tegb_demo_app.viewModel.SignUpViewModel

class SignUpActivity : BaseActivity<ActivitySignUpBinding, SignUpViewModel>() {

    private lateinit var handler: Handler

    override fun setViewModel(): SignUpViewModel = ViewModelProvider(this)[SignUpViewModel::class.java]

    override fun getResId(): Int = R.layout.activity_sign_up

    override fun setUpView() {

        binding.viewModel = viewModel
        handler = Looper.myLooper()?.let { Handler(it) }!!
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

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun observer() {

        viewModel.validationSignUp.observe(this) {
            binding.btnSignUp.startAnimation()
        }
        viewModel.userCreated.observe(this) {
            Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
            binding.btnSignUp.stopAnimation()
            handler.postDelayed({
                launchActivity<LoginActivity>()
            }, 500)
        }
        viewModel.createUserFail.observe(this) {
            binding.btnSignUp.doneLoadingAnimation(1, getDrawable(R.drawable.baseline_close_24)!!.toBitmap())
            handler.postDelayed({
                binding.btnSignUp.revertAnimation()
            }, 500)
            Toast.makeText(this, "${viewModel.createUserFail.value}", Toast.LENGTH_SHORT).show()
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