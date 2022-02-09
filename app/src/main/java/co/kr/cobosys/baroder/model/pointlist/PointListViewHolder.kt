package co.kr.cobosys.baroder.model.pointlist

import android.annotation.SuppressLint
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import co.kr.cobosys.baroder.app.databinding.ItemHomeCardExpandBinding
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.load
import co.kr.cobosys.baroder.extension.visible
import co.kr.cobosys.baroder.model.PointListUI

class PointListViewHolder(private val itemBinding: ItemHomeCardExpandBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(favorite: PointListUI) = with(itemView) {
        itemBinding.pointCard.transitionName = favorite.code
        itemBinding.storeName.text = favorite.storeName
        itemBinding.point.text = favorite.point
        itemBinding.mainText.text = "${favorite.maxPoint} 포인트까지 ${favorite.minPoint}포인트 남았어요!"
        itemBinding.startPoint.text = favorite.minPoint.toString()
        itemBinding.endPoint.text = favorite.maxPoint.toString()
        itemBinding.couponBtn.text = favorite.coupon.toString()
        itemBinding.expandFirstText.text = favorite.bestProduct?.component1()
        itemBinding.expandSecondText.text = favorite.bestProduct?.component2()
        itemBinding.expandThirdText.text = favorite.bestProduct?.component3()
        itemBinding.expandFirstImg.load(favorite.bestProductImgUrl?.component1())
        itemBinding.expandSecondImg.load(favorite.bestProductImgUrl?.component2())
        itemBinding.expandThirdImg.load(favorite.bestProductImgUrl?.component3())

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