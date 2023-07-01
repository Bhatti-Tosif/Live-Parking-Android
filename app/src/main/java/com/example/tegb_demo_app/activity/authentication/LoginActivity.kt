package com.example.tegb_demo_app.activity.authentication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModelProvider
import com.example.tegb_demo_app.R
import com.example.tegb_demo_app.activity.dashBoard.DashBoardMainActivity
import com.example.tegb_demo_app.baseClass.BaseActivity
import com.example.tegb_demo_app.databinding.ActivityLoginBinding
import com.example.tegb_demo_app.utils.sharedPrefference.prefs
import com.example.tegb_demo_app.viewModel.AuthenticationViewModel
import com.google.android.material.snackbar.Snackbar

class LoginActivity : BaseActivity<ActivityLoginBinding, AuthenticationViewModel>() {

    private lateinit var handler: Handler
    override fun setUpView() {
        binding.viewModel = viewModel
        handler = Handler(Looper.getMainLooper())
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

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun observer() {

        viewModel.loginValidation.observe(this) {
            binding.btnLogin.startAnimation()
        }
        viewModel.loginSuccess.observe(this) {
            binding.btnLogin.doneLoadingAnimation(2, getDrawable(R.drawable.baseline_check_24)!!.toBitmap())
            Log.d("Auth", prefs.authToken.toString())
            handler.postDelayed({
                val intent = Intent(this, DashBoardMainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }, 1000)
        }

        viewModel.loginFail.observe(this) {

            binding.btnLogin.doneLoadingAnimation(2, getDrawable(R.drawable.baseline_close_24)!!.toBitmap())
            handler.postDelayed({
                binding.btnLogin.revertAnimation()
            }, 1500)
            Snackbar.make(binding.root, it.toString(), Snackbar.LENGTH_SHORT).show()

        }

        viewModel.emailEmpty.observe(this) {
            binding.etEnterEmail.error = getString(R.string.email_require)
        }
        viewModel.passwordEmpty.observe(this) {
            binding.etPassword.error = getString(R.string.password_require)
        }
    }
}