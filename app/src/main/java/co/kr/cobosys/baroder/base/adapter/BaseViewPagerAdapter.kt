package co.kr.cobosys.baroder.base.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewPagerAdapter(
    vararg types: PagerCell<Code, ViewBinding>
): ListAdapter<Code, RecyclerView.ViewHolder>(BASE_DIFF_CALLBACK){

    private val pagerCellTypes: PagerCellTypes<Code, ViewBinding> = PagerCellTypes(*types)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return pagerCellTypes.of(viewType).holder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position).let {
            pagerCellTypes.of(it).bind(holder, it)
        }
    }

    override fun getItemViewType(position: Int): Int {
        getItem(position).let {
            return pagerCellTypes.of(it).type()
        }
    }

}