package co.kr.cobosys.baroder.home.viewholders

import androidx.recyclerview.widget.RecyclerView
import co.kr.cobosys.baroder.app.databinding.ItemHomeRecentlyVisitedStoreBinding
import co.kr.cobosys.baroder.extension.load
import co.kr.cobosys.baroder.models.StoreListUI

class RecentlyVisitedStoreListViewHolder(private val itemBinding: ItemHomeRecentlyVisitedStoreBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(recently: StoreListUI) = with(itemView) {
        itemBinding.recentlyStoreName.text = recently.name
        itemBinding.recentlyStoreImg.load(recently.imgUrl?.get(0))
    }
}