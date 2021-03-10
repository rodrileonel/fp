package com.appstuddio.cleanmvvm.features.coupons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appstuddio.cleanmvvm.R
import com.appstuddio.cleanmvvm.core.extensions.loadFromUrl
import com.appstuddio.cleanmvvm.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_coupons_detail.*


class CouponsDetailFragment(private val coupon: CouponView?) : BaseFragment() {
    override fun layoutId() = R.layout.fragment_coupons_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivImage.loadFromUrl(coupon?.image!!)
        tvName.text = coupon.name
        tvDescription.text = coupon.description
    }

}