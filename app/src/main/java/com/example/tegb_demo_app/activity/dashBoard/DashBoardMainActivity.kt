package com.example.tegb_demo_app.activity.dashBoard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tegb_demo_app.R
import com.example.tegb_demo_app.databinding.ActivityDashBoardMainBinding

class DashBoardMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashBoardMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.fragmentContainerView)
        binding.bottomNavBar.setupWithNavController(navController)
    }
}