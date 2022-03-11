package co.kr.cobosys.baroder.shop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import co.kr.cobosys.baroder.app.databinding.ItemShopCouponBinding
import co.kr.cobosys.baroder.base.adapter.BASE_DIFF_CALLBACK
import co.kr.cobosys.baroder.base.adapter.Code
import co.kr.cobosys.baroder.models.CouponPolicyListUI
import co.kr.cobosys.baroder.shop.viewholders.CouponPolicyListViewHolder
import co.kr.cobosys.baroder.shop.viewholders.CouponPolicyListViewHolderListener

class CouponPolicyListAdapter(
    private val couponPolicyListUI: List<CouponPolicyListUI>,
    private val listener: CouponPolicyListViewHolderListener
) :
    ListAdapter<Code, CouponPolicyListViewHolder>(
        BASE_DIFF_CALLBACK
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CouponPolicyListViewHolder {
        return CouponPolicyListViewHolder(
            ItemShopCouponBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            listener
        )
    }

    override fun getItemCount(): Int {
        return couponPolicyListUI.size
    }

    override fun onBindViewHolder(holder: CouponPolicyListViewHolder, position: Int) {
        holder.bind(couponPolicyListUI[position])
    }
}