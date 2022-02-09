package co.kr.cobosys.baroder.model.pointlist

import androidx.recyclerview.widget.RecyclerView
import co.kr.cobosys.baroder.app.databinding.ItemHomeCardBinding

class EmptyPointListViewHolder(private val itemBinding: ItemHomeCardBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind() = with(itemView) {
        itemBinding.emptyPointCard.transitionName
        itemBinding.emptyStoreName.text
        itemBinding.emptyPoint.text
        itemBinding.emptyStartPoint.text
        itemBinding.emptyEndPoint.text
        itemBinding.emptyFirstBtn.text
        itemBinding.emptySecondBtn.text
    }
}