package com.appstuddio.cleanmvvm.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface CouponsApi {
    companion object {
        private const val COUPONS = "4e83fc2a-e9c9-4fb7-9af7-dee5c761e7bb"
    }

    @GET(COUPONS) fun getCoupons(): Call<List<CouponEntity.Response>>
}