package co.kr.cobosys.baroder.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import co.kr.cobosys.baroder.app.databinding.ItemHomeStoreBinding
import co.kr.cobosys.baroder.base.adapter.BASE_DIFF_CALLBACK
import co.kr.cobosys.baroder.base.adapter.Code
import co.kr.cobosys.baroder.models.StoreListUI
import co.kr.cobosys.baroder.home.viewholders.StoreListViewHolder

class StoreListAdapter(private val storeListUI: List<StoreListUI>) :
    PagingDataAdapter<Code, StoreListViewHolder>(
        BASE_DIFF_CALLBACK
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreListViewHolder {
        return StoreListViewHolder(
            ItemHomeStoreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StoreListViewHolder, position: Int) {
        holder.bind(storeListUI[position])
    }

}