package co.kr.cobosys.baroder.model.favoritestore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import co.kr.cobosys.baroder.app.R
import co.kr.cobosys.baroder.app.databinding.ItemHomeCardExpandBinding
import co.kr.cobosys.baroder.base.adapter.RecyclerCell
import co.kr.cobosys.baroder.base.adapter.RecyclerItem
import co.kr.cobosys.baroder.model.FavoriteStoreUI

object FavoriteStoreCell: RecyclerCell<RecyclerItem, ViewBinding> {

    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is FavoriteStoreUI
    }

    override fun type(): Int {
        return R.layout.item_home_card_expand
    }

    override fun binding(parent: ViewGroup): ItemHomeCardExpandBinding {
        return ItemHomeCardExpandBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return FavoriteStoreViewHolder(binding(parent))
    }

    override fun bind(
        holder: RecyclerView.ViewHolder,
        item: RecyclerItem?,
        onItemClick: ((RecyclerItem, View) -> Unit)?
    ) {
        if (holder is FavoriteStoreViewHolder && item is FavoriteStoreUI) {
            holder.bind(item)
            holder.itemView.setOnClickListener {
                onItemClick?.run {
                    this(item, holder.itemBinding.pointCard)
                }
            }
        }
    }
}