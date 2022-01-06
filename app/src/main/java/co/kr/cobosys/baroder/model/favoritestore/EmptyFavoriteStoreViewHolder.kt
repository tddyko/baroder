package co.kr.cobosys.baroder.model.favoritestore

import androidx.recyclerview.widget.RecyclerView
import co.kr.cobosys.baroder.app.databinding.ItemHomeCardBinding
import co.kr.cobosys.baroder.model.EmptyFavoriteStoreUI

class EmptyFavoriteStoreViewHolder(private val itemBinding: ItemHomeCardBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(empty: EmptyFavoriteStoreUI) = with(itemView) {
        itemBinding.emptyPointCard.transitionName = empty.id.toString()
        itemBinding.emptyStoreName.text = empty.emptyStoreName
        itemBinding.emptyPoint.text = empty.emptyPoint
        itemBinding.emptyMainText.text = empty.emptyMainText
        itemBinding.emptyStartPoint.text = empty.emptyStartPoint.toString()
        itemBinding.emptyEndPoint.text = empty.emptyEndPoint.toString()
        itemBinding.emptyFirstBtn.text = empty.firstBtn
        itemBinding.emptySecondBtn.text = empty.secondBtn
    }
}