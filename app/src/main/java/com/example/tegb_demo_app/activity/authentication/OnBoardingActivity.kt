package com.example.tegb_demo_app.activity.authentication

import androidx.lifecycle.ViewModelProvider
import com.example.tegb_demo_app.R
import com.example.tegb_demo_app.baseClass.BaseActivity
import com.example.tegb_demo_app.databinding.ActivityOnBoardingBinding
import com.example.tegb_demo_app.viewModel.OnBoardingViewModel

class OnBoardingActivity : BaseActivity<ActivityOnBoardingBinding, OnBoardingViewModel>() {

    override fun setViewModel(): OnBoardingViewModel = ViewModelProvider(this)[OnBoardingViewModel::class.java]

    override fun getResId(): Int = R.layout.activity_on_boarding

    override fun setUpView() {
        binding.viewModel = viewModel
        initialSetUp()
        observer()
    }

    private fun observer() {

        viewModel.navigation.observe(this) {
            when (it) {
                OnBoardingViewModel.NavigationEvent.LoginEvent -> launchActivity<LoginActivity>()
                OnBoardingViewModel.NavigationEvent.SignUpEvent -> launchActivity<SignUpActivity>()
            }
        }
    }

    private fun initialSetUp() {

//        if (prefs.isUserLogin) {
//            launchActivity<DashBoardMainActivity>()
//            finish()
//        }
    }

//    private lateinit var binding: ActivityOnBoardingBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.btnLogin.setOnClickListener(this)
//        binding.btnSignUp.setOnClickListener(this)
//
//        if (prefs.isUserLogin) {
//            val intent = Intent(this, DashBoardMainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }

    //    override fun onClick(v: View?) {
//        when (v?.id) {
//            binding.btnLogin.id -> {
//                val intent = Intent(this, LoginActivity::class.java)
//                startActivity(intent)
//            }
//            binding.btnSignUp.id -> {
//                val intent = Intent(this, SignUpActivity::class.java)
//                startActivity(intent)
//            }
//        }
//    }

}