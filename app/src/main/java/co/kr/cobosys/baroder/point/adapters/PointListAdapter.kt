package co.kr.cobosys.baroder.point.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import co.kr.cobosys.baroder.app.databinding.ItemPointCardBinding
import co.kr.cobosys.baroder.base.adapter.BASE_DIFF_CALLBACK
import co.kr.cobosys.baroder.base.adapter.Code
import co.kr.cobosys.baroder.models.PointDataUI
import co.kr.cobosys.baroder.point.viewholders.PointViewHolder
import co.kr.cobosys.baroder.point.viewholders.PointViewHolderListener

class PointListAdapter(
    private val pointDataUI: PointDataUI,
    private val listener: PointViewHolderListener
) :
    ListAdapter<Code, PointViewHolder>(
        BASE_DIFF_CALLBACK
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PointViewHolder {
        return PointViewHolder(
            ItemPointCardBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            listener
        )
    }

    override fun getItemCount(): Int {
        return pointDataUI.pointList.size
    }

    override fun onBindViewHolder(holder: PointViewHolder, position: Int) {
        holder.bind(pointDataUI.pointList[position])
    }
}