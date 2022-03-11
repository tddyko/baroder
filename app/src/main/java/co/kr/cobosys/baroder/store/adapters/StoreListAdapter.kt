package co.kr.cobosys.baroder.store.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import co.kr.cobosys.baroder.app.databinding.ItemStoreCardBinding
import co.kr.cobosys.baroder.base.adapter.BASE_DIFF_CALLBACK
import co.kr.cobosys.baroder.base.adapter.Code
import co.kr.cobosys.baroder.models.StoreListUI
import co.kr.cobosys.baroder.store.viewholders.StoreListViewHolder

class StoreListAdapter(private val storeListUI: List<StoreListUI>) :
    ListAdapter<Code, StoreListViewHolder> (BASE_DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StoreListViewHolder {
        return StoreListViewHolder(
            ItemStoreCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return storeListUI.size
    }

    override fun onBindViewHolder(holder: StoreListViewHolder, position: Int) {
        holder.bind(storeListUI[position])
    }
}