package com.example.rainbow.playground

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rainbow.playground.databinding.ItemDlsComponentBinding

class DlsComponentAdapter(private val onClickListItem: (item: DlsComponentListItem) -> Unit) :
  ListAdapter<DlsComponentListItem, DlsComponentAdapter.ViewHolder>(
    DlsComponentListItemDiffCallback(),
  ) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding =
      ItemDlsComponentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(binding) { position -> onClickListItem(getItem(position)) }
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  class ViewHolder(
    private val binding: ItemDlsComponentBinding,
    private val onClickListItem: (position: Int) -> Unit,
  ) : RecyclerView.ViewHolder(binding.root) {
    init {
      itemView.setOnClickListener { onClickListItem(adapterPosition) }
    }

    fun bind(item: DlsComponentListItem) {
      binding.dlsComponentIcon.setImageDrawable(item.icon)
      binding.tvDlsComponentName.text = item.name
    }
  }
}

private class DlsComponentListItemDiffCallback : DiffUtil.ItemCallback<DlsComponentListItem>() {
  override fun areItemsTheSame(
    oldItem: DlsComponentListItem,
    newItem: DlsComponentListItem
  ): Boolean {
    return oldItem == newItem
  }

  override fun areContentsTheSame(
    oldItem: DlsComponentListItem,
    newItem: DlsComponentListItem
  ): Boolean {
    return oldItem == newItem
  }
}