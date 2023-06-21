package com.example.tegb_demo_app.utils.sharedPrefference

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {

    private val isUserLoginKey = "isUserLogin"
    private val authKey = "authKey"
    private val refreshTokenKey = "refreshToken"
    private val preferenceName = "MyPreference"
    private val authTokenKey = "authToken"

    private val preference: SharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)

    var isUserLogin: Boolean
        get() = preference.getBoolean(isUserLoginKey, false)
        set(value) = preference.edit().putBoolean(isUserLoginKey, value).apply()

    var userAuthKey: String?
        get() = preference.getString(authKey, "")
        set(value) = preference.edit().putString(authKey, value).apply()

    var refreshToken: String?
        get() = preference.getString(refreshTokenKey, "")
        set(value) = preference.edit().putString(refreshTokenKey, value).apply()

    var authToken: String?
        get() = preference.getString(authTokenKey, "")
        set(value) = preference.edit().putString(refreshTokenKey, value).apply()
}