package com.example.tegb_demo_app.model.response


import com.google.gson.annotations.SerializedName

data class ParkingLocationResponseModel(
    val id : Int,
    @SerializedName("parkingLot")
    val parking_lot: ParkingLot,
    @SerializedName("Parking_Lot_Images")
    val parkingImage: ParkingImage
)

data class ParkingLot(
    @SerializedName("name")
    val name: String,
    @SerializedName("Address")
    val address: Address
)

data class Address (
    @SerializedName("addressLine1")
    val addressLine1: String,
)

data class ParkingImage(
    @SerializedName("doc_path")
    val image: String
)
