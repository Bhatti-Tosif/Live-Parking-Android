package com.example.tegb_demo_app.activity.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tegb_demo_app.activity.dashBoard.DashBoardMainActivity
import com.example.tegb_demo_app.databinding.ActivityLoginBinding
import com.example.tegb_demo_app.model.request.LoginRequestModel
import com.example.tegb_demo_app.utils.sharedPrefference.prefs
import com.example.tegb_demo_app.viewModel.AuthenticationViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: AuthenticationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = AuthenticationViewModel()
        binding.btnLogin.setOnClickListener(this)
        binding.toolBar.ibRightSide.setOnClickListener(this)

        viewModel.loginSuccess.observe(this) {
            prefs.isUserLogin = true
            prefs.userAuthKey = it?.authToken
            prefs.refreshToken = it?.refreshToken
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DashBoardMainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }

//    override fun setUpView() {
//        binding.btnLogin.setOnClickListener {
//            loginRequest()
//        }
//        observer()
//    }
//    override fun setViewModel(): AuthenticationViewModel? = ViewModelProvider(this)[AuthenticationViewModel::class.java]
//
//    override fun getResId(): Int = R.layout.activity_login

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnLogin.id -> {
                val userRequest = LoginRequestModel(
                    binding.etEnterEmail.text.toString(),
                    binding.etPassword.text.toString(),
                    "business"
                )
                viewModel.loginUser(userRequest)
            }
            binding.toolBar.ibRightSide.id -> {
                finish()
            }
        }
    }
//    private fun loginRequest() {
//        val userRequest = LoginRequestModel(binding.etEnterEmail.text.toString(), binding.etPassword.text.toString(), "business")
//        viewModel.loginUser(userRequest)
//    }
//
//    private fun observer() {
//        viewModel.loginSuccess.observe(this) {
//            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
//            val intent = Intent(this, DashBoardMainActivity::class.java)
//            startActivity(intent)
//        }
//    }
}