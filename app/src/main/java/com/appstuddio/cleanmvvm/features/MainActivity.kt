package com.appstuddio.cleanmvvm.features

import com.appstuddio.cleanmvvm.core.platform.BaseActivity
import com.appstuddio.cleanmvvm.features.coupons.CouponsFragment

class MainActivity : BaseActivity() {
    override fun showToolbar() = false
    override fun fragment() = CouponsFragment()
}