package com.example.tegb_demo_app.model.request

data class SignUpRequestModel(
    var firstName: String,
    var lastName: String,
    var email: String,
    var mobileNumber: String,
    var password: String,
    var businessName: String = "Developer",
    var businessAddress: String = "simform",
    var country: String = "India",
    var state: String = "Gujarat",
    var city: String = "Ahmedabad",
    var zipCode: String = "333310",
    var userType: String = "business",
    var newsLetterAlert: Boolean = true,
    var registrationPlatform: String = "email",
    var termsAgreement: Boolean = true,
    var platform: String = "ios",
    var deviceId: String = "",
    var deviceToken: String = "deviceToken",
    var phoneExtension: String = "Yes",
)