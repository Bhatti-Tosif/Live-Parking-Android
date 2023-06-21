package com.example.tegb_demo_app.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tegb_demo_app.R
import com.example.tegb_demo_app.databinding.FragmentParkingLocationBinding

class ParkingLocationFragment : Fragment() {

    private lateinit var binding: FragmentParkingLocationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentParkingLocationBinding.inflate(inflater)

        return binding.root
    }
}