package com.example.tegb_demo_app.model.response

import androidx.core.app.NotificationCompat.Action.SemanticAction
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("User")
    val user : UserInfo?,
    val refreshToken : String?,
    val authToken : String?
)

data class UserInfo(
    @SerializedName("id")
    val userId: Int?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("user_type")
    val userType: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("registration_platform")
    val registrationPlatform: String?,
    val isActive: Boolean?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("business_name")
    val businessName: String?,
    val photo: String?,
    @SerializedName("phone_number")
    val phoneNumber: String?,
    var fullName: String?,
    @SerializedName("wallet_balance")
    var walletBalance: String?,
    @SerializedName("phone_country_code")
    var phoneCountryCode: String?,
    var phoneWithPrefix: String?,
    val isInstituteMember: Boolean?
)