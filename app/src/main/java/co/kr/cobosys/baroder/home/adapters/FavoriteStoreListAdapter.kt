package co.kr.cobosys.baroder.home.adapters

import android.view.View
import co.kr.cobosys.baroder.base.adapter.BasePagedListAdapter
import co.kr.cobosys.baroder.base.adapter.RecyclerItem
import co.kr.cobosys.baroder.model.favoritestore.favoriteStoreCell

class favoriteStoreListAdapter(onItemClick: (RecyclerItem, View) -> Unit): BasePagedListAdapter(
    favoriteStoreCell,
    onItemClick = onItemClick
)