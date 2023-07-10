package com.example.tegb_demo_app.activity.dashBoard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tegb_demo_app.R
import com.example.tegb_demo_app.activity.authentication.OnBoardingActivity
import com.example.tegb_demo_app.databinding.ActivityDashBoardMainBinding
import com.example.tegb_demo_app.utils.sharedPrefference.prefs

class DashBoardMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashBoardMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.fragmentContainerView)
        binding.bottomNavBar.setupWithNavController(navController)

        binding.btnLogOut.setOnClickListener {
            prefs.isUserLogin = false
            val intent = Intent(this, OnBoardingActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or  Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        binding.toolBar.ibRightSide.setOnClickListener {
            finish()
        }
    }
}