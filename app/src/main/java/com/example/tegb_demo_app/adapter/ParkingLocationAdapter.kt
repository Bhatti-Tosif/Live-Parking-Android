package com.example.tegb_demo_app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tegb_demo_app.databinding.ItemParkingLocationBinding
import com.example.tegb_demo_app.model.response.ParkingLocationResponseModel

class ParkingLocationAdapter(): RecyclerView.Adapter<ParkingLocationAdapter.ParkingLocationViewHolder>() {

    private var dataList = arrayListOf<ParkingLocationResponseModel>()
    var isClicked = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkingLocationViewHolder = ParkingLocationViewHolder(
        ItemParkingLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ParkingLocationViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    inner class ParkingLocationViewHolder(val binding: ItemParkingLocationBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ParkingLocationResponseModel) {
            binding.viewModel = item

            binding.parkingLocationCard.setOnClickListener {
                toggleImage()
            }
        }

        private fun toggleImage() {
            if (isClicked){
                binding.imgCheck.visibility = View.GONE

            } else {
                binding.imgCheck.visibility = View.VISIBLE
            }
            isClicked = !isClicked
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: ArrayList<ParkingLocationResponseModel>) {
        val diffUtil = PromoCodeDiffUtils(dataList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        dataList.clear()
        dataList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
        notifyDataSetChanged()
    }

    class PromoCodeDiffUtils(private val oldList: ArrayList<ParkingLocationResponseModel>, private val newList: ArrayList<ParkingLocationResponseModel>): DiffUtil.Callback() {
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