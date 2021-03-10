package com.appstuddio.cleanmvvm.features.coupons

import androidx.lifecycle.MutableLiveData
import com.appstuddio.cleanmvvm.core.interactor.UseCase
import com.appstuddio.cleanmvvm.core.platform.BaseViewModel
import com.appstuddio.cleanmvvm.features.coupons.models.Coupon
import com.appstuddio.cleanmvvm.features.coupons.usecase.GetCoupons
import javax.inject.Inject

class CouponsViewModel
@Inject constructor(private val getCoupons: GetCoupons) : BaseViewModel() {

    var coupons: MutableLiveData<List<CouponView>> = MutableLiveData()

    fun loadCoupons() = getCoupons(UseCase.None()) { it.either(::handleFailure, ::handleCouponList) }

    private fun handleCouponList(coupons: List<Coupon>) {
        this.coupons.value = coupons.map { CouponView(it.id, it.name, it.description, it.image) }
    }

}