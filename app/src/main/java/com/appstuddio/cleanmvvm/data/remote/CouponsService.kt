package com.appstuddio.cleanmvvm.data.remote

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CouponsService
@Inject constructor(retrofit: Retrofit) : CouponsApi {
    private val couponsApi by lazy { retrofit.create(CouponsApi::class.java) }

    override fun getCoupons() = couponsApi.getCoupons()
}
