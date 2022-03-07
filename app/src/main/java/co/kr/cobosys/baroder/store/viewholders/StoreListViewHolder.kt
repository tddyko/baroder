package co.kr.cobosys.baroder.store.viewholders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import co.kr.cobosys.baroder.app.databinding.ItemStoreCardBinding
import co.kr.cobosys.baroder.models.StoreListUI
import com.bumptech.glide.Glide

class StoreListViewHolder(private val itemBinding: ItemStoreCardBinding) :
    RecyclerView.ViewHolder(itemBinding.root){
    @SuppressLint("SetTextI18n")
    fun bind(storeUI: StoreListUI) = with(itemView) {
        itemBinding.storeListUI = storeUI
        itemBinding.executePendingBindings()

        if (storeUI.srcImage.isNotEmpty())
            Glide.with(this).load(storeUI.srcImage).into(itemBinding.storeImage)

        itemBinding.root.setOnClickListener {
            val position = absoluteAdapterPosition

            if (position == RecyclerView.NO_POSITION)
                return@setOnClickListener

            // onClickListener(position)
        }
//        itemBinding.storeName.text = storeUI.name
//        itemBinding.storeDistance.text = "${storeUI.distance}"
//        itemBinding.storeAddress.text = storeUI.address
    }
}
