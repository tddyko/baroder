package co.kr.cobosys.baroder.model.adapters.home

import android.annotation.SuppressLint
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import co.kr.cobosys.baroder.app.databinding.ItemHomeCardExpandBinding
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.load
import co.kr.cobosys.baroder.extension.visible
import co.kr.cobosys.baroder.model.RegularStoreListUI

class RegularStoreListViewHolder(private val itemBinding: ItemHomeCardExpandBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(regular: RegularStoreListUI) = with(itemView) {
        itemBinding.pointCard.transitionName = regular.code
        itemBinding.storeName.text = regular.storeName
        itemBinding.point.text = regular.point
        itemBinding.mainText.text = "${regular.maxPoint} 포인트까지 ${regular.minPoint}포인트 남았어요!"
        itemBinding.startPoint.text = regular.minPoint.toString()
        itemBinding.endPoint.text = regular.maxPoint.toString()
        itemBinding.couponBtn.text = regular.coupon.toString()
        itemBinding.expandFirstText.text = regular.bestProduct.component1().toString()
        itemBinding.expandSecondText.text = regular.bestProduct.component2().toString()
        itemBinding.expandThirdText.text = regular.bestProduct.component3().toString()
        itemBinding.expandFirstImg.load(regular.bestProductImgUrl.component1())
        itemBinding.expandSecondImg.load(regular.bestProductImgUrl.component2())
        itemBinding.expandThirdImg.load(regular.bestProductImgUrl.component3())

        itemBinding.couponBtn.setOnClickListener {
            Toast.makeText(context, "버튼눌림", Toast.LENGTH_SHORT).show()
        }

        itemBinding.expandTitleConstraint.setOnClickListener {
            if (itemBinding.expandItem.visibility == View.VISIBLE) {
                itemBinding.expandItem.gone()
                itemBinding.arrowImg.animate().setDuration(200).rotation(0f)
            } else {
                itemBinding.expandItem.visible()
                itemBinding.arrowImg.animate().setDuration(200).rotation(180f)
            }
        }

    }
}