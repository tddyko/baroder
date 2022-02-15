package co.kr.cobosys.baroder.home.viewholders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import co.kr.cobosys.baroder.app.databinding.ItemHomeRegularStoreBinding
import co.kr.cobosys.baroder.extension.load
import co.kr.cobosys.baroder.model.RegularStoreListUI

class RegularStoreListViewHolder(private val itemBinding: ItemHomeRegularStoreBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(regular: RegularStoreListUI) = with(itemView) {
        itemBinding.regularStoreArea.transitionName = regular.code
        itemBinding.regularStoreName.text = regular.regularStoreName
        itemBinding.regularStorePoint.text = regular.point
        itemBinding.regularStoreTargetPoint.text = "${regular.maxPoint} 포인트까지 ${regular.minPoint}포인트 남았어요!"
        itemBinding.regularStoreMinPoint.text = regular.minPoint.toString()
        itemBinding.regularStoreMaxPoint.text = regular.maxPoint.toString()
        itemBinding.regularStoreCouponBtn.text = regular.coupon.toString()
        itemBinding.regularStoreBestProductTitleFirst.text = regular.bestProduct.component1().toString()
        itemBinding.regularStoreBestProductTitleSecond.text = regular.bestProduct.component2().toString()
        itemBinding.regularStoreBestProductTitleThird.text = regular.bestProduct.component3().toString()
        itemBinding.regularStoreBestProductImgFirst.load(regular.bestProductImgUrl?.component1())
        itemBinding.regularStoreBestProductImgSecond.load(regular.bestProductImgUrl?.component2())
        itemBinding.regularStoreBestProductImgThird.load(regular.bestProductImgUrl?.component3())
    }
}