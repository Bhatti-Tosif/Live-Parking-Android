package com.example.tegb_demo_app.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tegb_demo_app.adapter.PromoCodeAdapter
import com.example.tegb_demo_app.databinding.FragmentPromocodeBinding
import com.example.tegb_demo_app.model.response.PromoCodeResponseModel
import com.example.tegb_demo_app.viewModel.PromoCodeViewModel

class PromoCodeFragment : Fragment() {

    private lateinit var binding: FragmentPromocodeBinding
    private lateinit var promoCodeAdapter: PromoCodeAdapter
    private lateinit var viewModel: PromoCodeViewModel
    var promoCodeList = ArrayList<PromoCodeResponseModel>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPromocodeBinding.inflate(inflater)
        viewModel = PromoCodeViewModel()
        prepareRecyclerView()
        observer()
        getPromoCode()
        return binding.root

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observer() {
        viewModel.promoCodeDetail.observe(viewLifecycleOwner) { data ->
            binding.shimmerContainer.stopShimmer()
            binding.shimmerContainer.visibility = View.GONE
            promoCodeList.clear()
            if (data != null) {
                Log.d("DATA", data.toString())
                promoCodeList.addAll(data)
            }
            promoCodeAdapter.submitList(promoCodeList)
            promoCodeAdapter.notifyDataSetChanged()
        }
    }

    private fun prepareRecyclerView()  {
        binding.shimmerContainer.startShimmer()
        promoCodeAdapter = PromoCodeAdapter()
        binding.rvPromoCode.apply {
            adapter = promoCodeAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
    private fun getPromoCode() {
        viewModel.getPromoCode()
    }
}