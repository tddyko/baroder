package co.kr.cobosys.baroder.base.adapter

import androidx.recyclerview.widget.DiffUtil

val BASE_DIFF_CALLBACK = object : DiffUtil.ItemCallback<Code>() {
    override fun areItemsTheSame(oldItem: Code, newItem: Code): Boolean {
        return oldItem.code == newItem.code
    }

    override fun areContentsTheSame(oldItem: Code, newItem: Code): Boolean {
        return oldItem == newItem
    }
}