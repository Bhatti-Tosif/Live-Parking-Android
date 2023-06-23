package com.example.tegb_demo_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tegb_demo_app.baseClass.BaseViewModel

class OnBoardingViewModel: BaseViewModel() {

    private val _navigation = MutableLiveData<NavigationEvent>()
    val navigation: LiveData<NavigationEvent>
        get() = _navigation


    sealed class NavigationEvent {
        object LoginEvent : NavigationEvent()
        object SignUpEvent: NavigationEvent()
    }

    fun gotoLogin() {
        _navigation.value = NavigationEvent.LoginEvent
    }

    fun gotoSignUp() {
        _navigation.value = NavigationEvent.SignUpEvent
    }
}