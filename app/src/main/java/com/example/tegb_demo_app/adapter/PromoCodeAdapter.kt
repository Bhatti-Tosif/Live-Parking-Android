package com.example.tegb_demo_app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tegb_demo_app.databinding.ItemPromocodeListBinding
import com.example.tegb_demo_app.model.response.PromoCodeResponseModel

class PromoCodeAdapter: RecyclerView.Adapter<PromoCodeAdapter.PromoCodeViewHolder>() {

    private var dataList: ArrayList<PromoCodeResponseModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoCodeViewHolder = PromoCodeViewHolder(ItemPromocodeListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: PromoCodeViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    inner class PromoCodeViewHolder(private val binding: ItemPromocodeListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PromoCodeResponseModel) {
            binding.viewModel = item
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: ArrayList<PromoCodeResponseModel>) {
        val diffUtil = PromoCodeDiffUtils(dataList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        dataList.clear()
        dataList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
        notifyDataSetChanged()
    }

    class PromoCodeDiffUtils(private val oldList: ArrayList<PromoCodeResponseModel>, private val newList: ArrayList<PromoCodeResponseModel>): DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItemPosition == newItemPosition
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItemPosition == newItemPosition
        }

    }
}