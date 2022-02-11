package co.kr.cobosys.baroder.model.adapters.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.ItemHomeRecentlyVisitedStoreBinding
import co.kr.cobosys.baroder.base.adapter.PagerCell
import co.kr.cobosys.baroder.base.adapter.RecyclerItem
import co.kr.cobosys.baroder.model.RecentlyVisitedStoreListUI

object RecentlyVisitedStoreListCell: PagerCell<RecyclerItem, ViewBinding> {
    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is RecentlyVisitedStoreListUI
    }

    override fun type(): Int {
        return R.layout.item_recently_visited_store
    }

    override fun binding(parent: ViewGroup): ItemHomeRecentlyVisitedStoreBinding {
        return ItemHomeRecentlyVisitedStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return RecentlyVisitedStoreListViewHolder(binding(parent))
    }

    override fun bind(holder: RecyclerView.ViewHolder, item: RecyclerItem?) {
        if(holder is RecentlyVisitedStoreListViewHolder && item is RecentlyVisitedStoreListUI) {
            holder.bind(item)
        }
    }
}