package com.example.tegb_demo_app.utils.sharedPrefference

import android.app.Application

val prefs: Preferences by lazy {
    App.prefs!!
}

/** This class for global access sharedPreferences */
class App: Application() {

    companion object {
        var prefs: Preferences? = null
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        prefs = Preferences(applicationContext)
    }

}