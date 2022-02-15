package co.kr.cobosys.baroder.home.viewholders

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.kr.cobosys.baroder.app.databinding.ItemHomeStoreBinding
import co.kr.cobosys.baroder.extension.load
import co.kr.cobosys.baroder.model.StoreListUI

class StoreListViewHolder(private val itemBinding: ItemHomeStoreBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(store: StoreListUI) = with(itemView) {
        itemBinding.homeStoreConstraint.transitionName = store.code
        itemBinding.homeStoreName.text = store.name
        itemBinding.homeStoreAddress.text = store.address
        itemBinding.homeStoreFavoriteCheck.isChecked = store.favorite
        itemBinding.homeStoreRegularImg.visibility = if(store.regular == "y") View.VISIBLE else View.GONE
        itemBinding.homeStoreDistance.text = store.distance.toString()
        itemBinding.homeStoreImg.load(store.imgUrl?.get(0))
    }
}