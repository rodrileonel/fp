package com.appstuddio.cleanmvvm.features.coupons.usecase

import com.appstuddio.cleanmvvm.core.interactor.UseCase
import com.appstuddio.cleanmvvm.data.repository.CouponsRepository
import com.appstuddio.cleanmvvm.features.coupons.models.Coupon
import javax.inject.Inject

class GetCoupons
@Inject constructor(private val couponsRepository: CouponsRepository) : UseCase<List<Coupon>, UseCase.None>() {

    override suspend fun run(params: None) = couponsRepository.coupons()
}