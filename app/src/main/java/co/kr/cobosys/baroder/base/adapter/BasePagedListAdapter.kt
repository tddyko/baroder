package co.kr.cobosys.baroder.base.adapter

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BasePagedListAdapter(
    vararg types: RecyclerCell<Code, ViewBinding>,
    private val onItemClick: (Code, View) -> Unit
) : PagingDataAdapter<Code, RecyclerView.ViewHolder>(BASE_DIFF_CALLBACK) {

    private val recycleCellTypes: RecyclerCellTypes<Code, ViewBinding> = RecyclerCellTypes(*types)

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