package co.kr.cobosys.baroder.shop.viewholders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.ItemShopCouponBinding
import co.kr.cobosys.baroder.models.CouponPolicyListUI

interface CouponPolicyListViewHolderListener {
    fun onClickCouponPolicy(idx: Int)
}

class CouponPolicyListViewHolder(
    private val itemBinding: ItemShopCouponBinding,
    private val listener: CouponPolicyListViewHolderListener
) :
    RecyclerView.ViewHolder(itemBinding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(couponPolicyListUI: CouponPolicyListUI) = with(itemView) {
        when (couponPolicyListUI.couponNumber) {
            1 -> itemBinding.shopCouponImage.setImageResource(R.drawable.ic_coupon_img_500_b)
            2 -> itemBinding.shopCouponImage.setImageResource(R.drawable.ic_coupon_img_1000_b)
            3 -> itemBinding.shopCouponImage.setImageResource(R.drawable.ic_coupon_img_2000_b)
            4 -> itemBinding.shopCouponImage.setImageResource(R.drawable.ic_coupon_img_3000_b)
            5 -> itemBinding.shopCouponImage.setImageResource(R.drawable.ic_coupon_img_5000_b)
            6 -> itemBinding.shopCouponImage.setImageResource(R.drawable.ic_coupon_img_10000_b)
        }
        itemBinding.shopCouponContent.text = "${couponPolicyListUI.couponPrice} 원"
        itemBinding.shopCouponPoint.text = "${couponPolicyListUI.couponPrice} P"

        itemBinding.root.setOnClickListener {
            val position = absoluteAdapterPosition

            if (position == RecyclerView.NO_POSITION)
                return@setOnClickListener

            listener.onClickCouponPolicy(position)
        }

    }
}