package co.kr.cobosys.baroder.model.adapters.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.ItemHomeCardBinding
import co.kr.cobosys.baroder.base.adapter.PagerCell
import co.kr.cobosys.baroder.base.adapter.RecyclerItem
import co.kr.cobosys.baroder.model.EmptyPointListUI

object EmptyPointListCell: PagerCell<RecyclerItem, ViewBinding> {
    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is EmptyPointListUI
    }

    override fun type(): Int {
        return R.layout.item_home_card_expand
    }

    override fun binding(parent: ViewGroup): ItemHomeCardBinding {
        return ItemHomeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return EmptyPointListViewHolder(binding(parent))
    }

    override fun bind(holder: RecyclerView.ViewHolder, item: RecyclerItem?) {
        if(holder is EmptyPointListViewHolder && item is EmptyPointListUI) {
            holder.bind(item)
        }
    }
}