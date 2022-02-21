package co.kr.cobosys.baroder.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import co.kr.cobosys.baroder.app.databinding.ItemHomeRegularStoreBinding
import co.kr.cobosys.baroder.base.adapter.BASE_DIFF_CALLBACK
import co.kr.cobosys.baroder.base.adapter.Code
import co.kr.cobosys.baroder.extension.gone
import co.kr.cobosys.baroder.extension.visible
import co.kr.cobosys.baroder.models.RegularStoreListUI
import co.kr.cobosys.baroder.home.viewholders.RegularStoreListViewHolder


class RegularStoreListAdapter (private val regularStoreListUI: List<RegularStoreListUI>) :
    ListAdapter<Code, RegularStoreListViewHolder>(BASE_DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegularStoreListViewHolder {
        val itemBinding =
            ItemHomeRegularStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RegularStoreListViewHolder(
            itemBinding
        ).also { holder ->

            itemBinding.regularStoreCouponBtn.setOnClickListener {
                Toast.makeText(parent.context, "버튼눌림", Toast.LENGTH_SHORT).show()
            }

            itemBinding.regularStoreBestProductTitleArea.setOnClickListener {
                if (itemBinding.regularStoreBestProductArea.visibility == View.VISIBLE) {
                    itemBinding.regularStoreBestProductArea.gone()
                    itemBinding.regularStoreBestProductDetailBtn.animate().setDuration(200)
                        .rotation(0f)
                } else {
                    itemBinding.regularStoreBestProductArea.visible()
                    itemBinding.regularStoreBestProductDetailBtn.animate().setDuration(200)
                        .rotation(180f)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: RegularStoreListViewHolder, position: Int) {
        holder.bind(regularStoreListUI[position])
    }
}