package co.kr.cobosys.baroder.model.adapters.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.ItemHomeCardBinding
import co.kr.cobosys.baroder.base.adapter.PagerCell
import co.kr.cobosys.baroder.base.adapter.Code
import co.kr.cobosys.baroder.model.EmptyRegularStoreListUI

object EmptyRegularStoreListCell: PagerCell<Code, ViewBinding> {
    override fun belongsTo(item: Code?): Boolean {
        return item is EmptyRegularStoreListUI
    }

    override fun type(): Int {
        return R.layout.item_home_card_expand
    }

    override fun binding(parent: ViewGroup): ItemHomeCardBinding {
        return ItemHomeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return EmptyRegularStoreListViewHolder(binding(parent))
    }

    override fun bind(holder: RecyclerView.ViewHolder, item: Code?) {
        if(holder is EmptyRegularStoreListViewHolder && item is EmptyRegularStoreListUI) {
            holder.bind(item)
        }
    }
}