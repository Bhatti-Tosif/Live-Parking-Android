package com.example.tegb_demo_app.model.response

data class PromoCodeResponseModel(
    val id : Int,
    val couponName : String,
    val couponCode : String,
    val discountType : String,
    val discountValue : String,
    val maxDiscount : String,
    val startDate : String,
    val expiryDate : String,
    val usageLimit : Int,
    val active : Boolean
)