package com.appstuddio.cleanmvvm.data.remote

import com.appstuddio.cleanmvvm.features.coupons.models.Coupon
import com.google.gson.annotations.SerializedName

class CouponEntity {
    data class Response(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String?,
        @SerializedName("description") val description: String?,
        @SerializedName("image") val image: String?,
    ) {
        fun toCoupon() = Coupon(id,name,description,image)
    }
}