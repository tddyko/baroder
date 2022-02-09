package co.kr.cobosys.baroder.base.adapter

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BasePagedListAdapter(
    vararg types: RecyclerCell<RecyclerItem, ViewBinding>,
    private val onItemClick: (RecyclerItem, View) -> Unit
) : PagingDataAdapter<RecyclerItem, RecyclerView.ViewHolder>(BASE_DIFF_CALLBACK) {

    private val recycleCellTypes: RecyclerCellTypes<RecyclerItem, ViewBinding> = RecyclerCellTypes(*types)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return recycleCellTypes.of(viewType).holder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position).let {
            recycleCellTypes.of(it).bind(holder, it, onItemClick)
        }
    }
    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}