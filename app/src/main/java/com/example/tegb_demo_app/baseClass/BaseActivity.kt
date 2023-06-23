package com.example.tegb_demo_app.baseClass

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity<Binding: ViewDataBinding, ViewModel: BaseViewModel>: AppCompatActivity() {

    lateinit var binding: Binding
    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getResId())
        setViewModel().also {
            if (it != null) {
                viewModel = it
            }
        }
        with(binding) {
            setContentView(this.root)
            lifecycleOwner = this@BaseActivity
            //setVariable(BR.viewModel, viewModel)

        }
        setUpView()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val inputMethodManager =
                this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
            (currentFocus as? EditText)?.clearFocus()
        }
        return super.dispatchTouchEvent(ev)
    }

    abstract fun setViewModel(): ViewModel?

    abstract fun getResId(): Int

    open fun setUpView() {}

    open fun showError(error: String) {
        Snackbar.make(
            this,
            binding.root,
            error,
            Snackbar.LENGTH_SHORT,
        ).setBackgroundTint(Color.RED).show()
    }

    inline fun <reified T : AppCompatActivity> launchActivity() {
        val intent = Intent(this, T::class.java)
        startActivity(intent)
    }
}