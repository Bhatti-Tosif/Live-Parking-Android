package com.example.tegb_demo_app.utils

import com.example.tegb_demo_app.utils.sharedPrefference.prefs

object AppConstant {

    const val BASE_URL = "https://staging-auth-api.runparking.com/api/"
    const val SERVER_URL = "https://staging-core-api.runparking.com/api/"
    const val login_path = "auth/user/login"
    const val signup_path = "auth/user/signup"
    const val promoCode_path = "v5/user/promocode/fetch-promocodes"
    const val parking_location_path =
        "v5/user/favourite-location/list-favourite-locations?currentDateTime=2023-06-08T12:00:56Z"

    //Header Key
    private const val accept = "Accept"
    private const val authorization = "Authorization"
    private const val contentType = "Content-Type"
    private const val appVersion = "appversion"
    private const val plateForm = "plateform"

    /** This is for Reference
    private const val refreshToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoyNDc4LCJpYXQiOjE2ODczMzE0NDN9.HbtmBFZYx3MWOnthjFY-JresCdsaeVa_cwDqVxEqhc0"
    private const val authToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoyNDc4LCJpYXQiOjE2ODczMzE0NDMsImV4cCI6MTcxODg4OTA0M30.KxfvmiM_YO5KaHF8O_HHh_sPYwY-70S1cnlPPqo5i0l8DQ0lopFal8Q3Z7uaRsRT5vBffXNbZ4mRoOVd74LR60QLigZKps17PDAGuS42mdHXANGChnMza-zoY0hWhW4fNzO-HBe3QQFrzqvCfFjT4Epg57s4h1FGpAZpmVlcQMT-iadhceNwxDuv9WWwvDk8vu0Rpp62uA3a3gUoEGe-ytEXE4SV7haS-yX9le6otGdIc9If6Vop9LjJpbNB2Zwa_nuqQRhopbMJbxjyWRguYGrSbv4D3BoCTkCEJdlw_aw_MHe8XfA6cnvPcfmxNJPMzKDsBSRIlPAUqRljA7o-KAB2Rj-UfFve9NUZ58DgzbvXYxnjjsv6DbqIFb56I2miWSqB7VtIOb_2O0qqBHiWWgG8OmiSCHrZbAlJB6GjJ5dtOAbCX4y5GrJAUqgU5QHrVyZsKbchMlun8dkFjcfO9opBSJKlvPylPP9dRlhDzbAZIT5GIyshNgUJwfqAb2MvdY8Ntvv6AE9n4JqOllbGE4zeGqXfOTKYO6rwFBcOVaZrqQ7QX9ShJytX9s4NCCU9OFjHU40JBdp_B48diw_PTLRAHZZyzrXRBavVBQyHITvr1CbwqUNd003TCxwtiHbFpgI2BAFhS_mXQwqUT_PsauIGyZzqXku9ikWIl0a1Bhg"  */

    val commonHeader = mapOf(
        accept to "application/json",
        authorization to "accessToken",
        contentType to "application/json",
        appVersion to "1.0.3",
        plateForm to "ios"
    )

    val headerForPromoCode = mapOf(
        accept to "application/json",
        authorization to "Bearer ${prefs.userAuthKey}",
        contentType to "application/json",
        appVersion to "1.0.3",
        plateForm to "ios"
    )
}