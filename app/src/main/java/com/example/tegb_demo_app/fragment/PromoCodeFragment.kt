package com.example.tegb_demo_app.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tegb_demo_app.adapter.PromoCodeAdapter
import com.example.tegb_demo_app.databinding.FragmentPromocodeBinding
import com.example.tegb_demo_app.model.response.PromoCodeResponseModel
import com.example.tegb_demo_app.utils.AppConstant
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

        viewModel.promoCodeDetail.observe(viewLifecycleOwner) { data ->
            promoCodeList.clear()
            if (data != null) {
                Log.d("DATA", data.toString())
                promoCodeList.addAll(data)
            }
            promoCodeAdapter.submitList(promoCodeList)
            promoCodeAdapter.notifyDataSetChanged()
        }

        Log.d("Auth", "${AppConstant.authKey}")
        getPromoCode()

        return binding.root

    }

    private fun prepareRecyclerView()  {
//        binding.pbLoader.visibility = View.VISIBLE
//        binding.bgLoading.visibility = View.VISIBLE
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