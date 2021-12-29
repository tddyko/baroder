package co.kr.cobosys.baroder.home.adapters

import android.view.View
import co.kr.cobosys.baroder.base.adapter.BasePagedListAdapter
import co.kr.cobosys.baroder.base.adapter.RecyclerItem
import co.kr.cobosys.baroder.model.favoritestore.FavoriteStoreCell

class FavoriteStoreListAdapter(onItemClick: (RecyclerItem, View) -> Unit): BasePagedListAdapter(
    FavoriteStoreCell,
    onItemClick = onItemClick
)