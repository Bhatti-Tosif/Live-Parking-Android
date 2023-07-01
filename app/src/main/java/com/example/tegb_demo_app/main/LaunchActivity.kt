package com.example.tegb_demo_app.main

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import com.example.tegb_demo_app.R
import com.example.tegb_demo_app.activity.authentication.OnBoardingActivity
import com.example.tegb_demo_app.activity.dashBoard.DashBoardMainActivity
import com.example.tegb_demo_app.baseClass.BaseActivity
import com.example.tegb_demo_app.baseClass.BaseViewModel
import com.example.tegb_demo_app.databinding.ActivityLaunchBinding
import com.example.tegb_demo_app.utils.sharedPrefference.prefs

@SuppressLint("CustomSplashScreen")
class LaunchActivity : BaseActivity<ActivityLaunchBinding, BaseViewModel>() {

    override fun setViewModel(): BaseViewModel  = BaseViewModel()

    override fun getResId(): Int = R.layout.activity_launch

    override fun setUpView() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            if (prefs.isUserLogin) {
                launchActivity<DashBoardMainActivity>()
            } else {
                launchActivity<OnBoardingActivity>()
            }
            finish()
        }, 2000)
    }

}