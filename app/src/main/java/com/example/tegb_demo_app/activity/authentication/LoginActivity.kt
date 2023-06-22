package com.example.tegb_demo_app.activity.authentication

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.example.tegb_demo_app.R
import com.example.tegb_demo_app.activity.dashBoard.DashBoardMainActivity
import com.example.tegb_demo_app.baseClass.BaseActivity
import com.example.tegb_demo_app.databinding.ActivityLoginBinding
import com.example.tegb_demo_app.utils.sharedPrefference.prefs
import com.example.tegb_demo_app.viewModel.AuthenticationViewModel
import com.google.android.material.snackbar.Snackbar

class LoginActivity : BaseActivity<ActivityLoginBinding, AuthenticationViewModel>() {
    override fun setUpView() {
        binding.viewModel = viewModel
        binding.btnLogin.setOnClickListener {
            loginRequest()
        }

        binding.toolBar.ibRightSide.setOnClickListener {
            finish()
        }

        observer()
    }
    override fun setViewModel(): AuthenticationViewModel = ViewModelProvider(this)[AuthenticationViewModel::class.java]

    override fun getResId(): Int = R.layout.activity_login
    private fun loginRequest() {
        viewModel.doLogin()
    }

    private fun observer() {
        viewModel.loginSuccess.observe(this) {
            prefs.isUserLogin = true
            prefs.userAuthKey = it?.authToken
            prefs.refreshToken = it?.refreshToken
            val intent = Intent(this, DashBoardMainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        viewModel.loginFail.observe(this) {
            Snackbar.make(binding.root, getString(R.string.wrong_credential), Snackbar.LENGTH_SHORT).show()
        }

        viewModel.emailEmpty.observe(this) {
            binding.etEnterEmail.error = getString(R.string.email_require)
        }
        viewModel.passwordEmpty.observe(this) {
            binding.etPassword.error = getString(R.string.password_require)
        }
    }
}