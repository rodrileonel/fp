package com.appstuddio.cleanmvvm.features.coupons

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.appstuddio.cleanmvvm.R
import com.appstuddio.cleanmvvm.core.extensions.failure
import com.appstuddio.cleanmvvm.core.extensions.observe
import com.appstuddio.cleanmvvm.core.extensions.viewModel
import com.appstuddio.cleanmvvm.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_coupons.*
import javax.inject.Inject


class CouponsFragment : BaseFragment() {

    @Inject lateinit var couponsAdapter: CouponsAdapter
    private lateinit var couponsViewModel: CouponsViewModel

    override fun layoutId() = R.layout.fragment_coupons

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        couponsViewModel = viewModel(viewModelFactory) {
            observe(coupons, {
                it?.let {
                    couponsAdapter.collection = it
                }
            })
            failure(failure, {
                it?.let {

                }
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        couponsList.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        couponsList.adapter = couponsAdapter
        couponsAdapter.clickListener = {
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, CouponsDetailFragment(it))
            transaction.commit()
        }

        couponsViewModel.loadCoupons()

    }
}