package co.kr.cobosys.baroder.model.favoritestore

import androidx.recyclerview.widget.RecyclerView
import co.kr.cobosys.baroder.app.databinding.ItemHomeCardExpandBinding
import co.kr.cobosys.baroder.model.favoriteStoreUI

class favoriteStoreViewHolder(val itemBinding: ItemHomeCardExpandBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(favorite: favoriteStoreUI) = with(itemView) {
        itemBinding.pointCard.transitionName = favorite.id.toString()
        itemBinding.storeName.text = favorite.storeName.toString()
        itemBinding.point.text = favorite.point.toString()
        itemBinding.mainText.text = favorite.mainText
        itemBinding.startPoint.text = favorite.minPoint.toString()
        itemBinding.endPoint.text = favorite.maxPoint.toString()
        itemBinding.couponBtn.text = favorite.coupon.toString()
    }
}