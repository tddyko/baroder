package co.kr.cobosys.baroder.model.adapters.home

import androidx.recyclerview.widget.RecyclerView
import co.kr.cobosys.baroder.app.databinding.ItemHomeCardBinding
import co.kr.cobosys.baroder.model.EmptyPointListUI

class EmptyPointListViewHolder(private val itemBinding: ItemHomeCardBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(favorite: EmptyPointListUI) = with(itemView) {
        itemBinding.emptyPointCard.transitionName = favorite.code
        itemBinding.emptyStoreName.text = favorite.emptyStoreName
        itemBinding.emptyPoint.text = favorite.emptyPoint
        itemBinding.emptyStartPoint.text = favorite.emptyStartPoint.toString()
        itemBinding.emptyEndPoint.text = favorite.emptyEndPoint.toString()
        itemBinding.emptyFirstBtn.text = favorite.firstBtn
        itemBinding.emptySecondBtn.text = favorite.secondBtn
    }
}