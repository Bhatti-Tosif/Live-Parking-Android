package com.example.tegb_demo_app.baseClass

import android.graphics.drawable.DrawableContainer
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.tegb_demo_app.R
import com.example.tegb_demo_app.databinding.ActivityBaseBinding

abstract class BaseActivity(@LayoutRes private val layoutRes: Int): AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding
    private lateinit var imageButtonBack: ImageButton
    private lateinit var textViewTitle: TextView
    private lateinit var activityContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        activityContainer = binding.layoutContainer
        imageButtonBack = activityContainer.findViewById(R.id.image_back_button)
        textViewTitle = activityContainer.findViewById(R.id.text_screen_title)

    }

    fun screenTitle(title: String) {
        textViewTitle.text = title
    }

    fun getImageButton(): ImageButton {
        return imageButtonBack
    }
}