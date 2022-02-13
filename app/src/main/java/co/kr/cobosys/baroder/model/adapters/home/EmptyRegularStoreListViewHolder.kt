package co.kr.cobosys.baroder.model.adapters.home

import androidx.recyclerview.widget.RecyclerView
import co.kr.cobosys.baroder.app.databinding.ItemHomeCardBinding
import co.kr.cobosys.baroder.model.EmptyRegularStoreListUI

class EmptyRegularStoreListViewHolder(private val itemBinding: ItemHomeCardBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(regular: EmptyRegularStoreListUI) = with(itemView) {
        itemBinding.emptyPointCard.transitionName = regular.code
        itemBinding.emptyStoreName.text = regular.emptyStoreName
        itemBinding.emptyPoint.text = regular.emptyPoint
        itemBinding.emptyStartPoint.text = regular.emptyStartPoint.toString()
        itemBinding.emptyEndPoint.text = regular.emptyEndPoint.toString()
        itemBinding.emptyFirstBtn.text = regular.firstBtn
        itemBinding.emptySecondBtn.text = regular.secondBtn
    }
}