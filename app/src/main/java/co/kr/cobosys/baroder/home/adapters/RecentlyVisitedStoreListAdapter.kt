package co.kr.cobosys.baroder.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import co.kr.cobosys.baroder.app.databinding.ItemHomeRecentlyVisitedStoreBinding
import co.kr.cobosys.baroder.base.adapter.BASE_DIFF_CALLBACK
import co.kr.cobosys.baroder.base.adapter.Code
import co.kr.cobosys.baroder.home.viewholders.RecentlyVisitedStoreListViewHolder
import co.kr.cobosys.baroder.models.StoreListUI


class RecentlyVisitedStoreListAdapter(private val recentlyVisitedStoreListUI: List<StoreListUI>) :
    ListAdapter<Code, RecentlyVisitedStoreListViewHolder>(
        BASE_DIFF_CALLBACK
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecentlyVisitedStoreListViewHolder {
        return RecentlyVisitedStoreListViewHolder(
            ItemHomeRecentlyVisitedStoreBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecentlyVisitedStoreListViewHolder, position: Int) {
        holder.bind(recentlyVisitedStoreListUI[position])
    }

}