package co.kr.cobosys.baroder.model.adapters.home

import androidx.recyclerview.widget.RecyclerView
import co.kr.cobosys.baroder.app.databinding.ItemHomeRecentlyVisitedStoreBinding
import co.kr.cobosys.baroder.extension.load
import co.kr.cobosys.baroder.model.RecentlyVisitedStoreListUI

class RecentlyVisitedStoreListViewHolder(private val itemBinding: ItemHomeRecentlyVisitedStoreBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(recently: RecentlyVisitedStoreListUI) = with(itemView) {
        itemBinding.recentlyStoreName.text = recently.storeName
        itemBinding.recentlyStoreImg.load(recently.storeImgUrl[0])
    }
}