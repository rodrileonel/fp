package com.appstuddio.cleanmvvm.features.coupons

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appstuddio.cleanmvvm.R
import com.appstuddio.cleanmvvm.core.extensions.inflate
import com.appstuddio.cleanmvvm.core.extensions.loadFromUrl
import kotlinx.android.synthetic.main.row_coupon.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class CouponsAdapter
@Inject constructor() : RecyclerView.Adapter<CouponsAdapter.ViewHolder>() {

    internal var collection: List<CouponView> by Delegates.observable(emptyList()) {
            _, _, _ -> notifyDataSetChanged()
    }

    internal var clickListener: (CouponView) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.row_coupon))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(collection[position], clickListener)

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(couponView: CouponView, clickListener: (CouponView) -> Unit) {
            itemView.couponPoster.loadFromUrl("https://source.unsplash.com/random/?coupon")
            itemView.setOnClickListener { clickListener(couponView) }
        }
    }
}