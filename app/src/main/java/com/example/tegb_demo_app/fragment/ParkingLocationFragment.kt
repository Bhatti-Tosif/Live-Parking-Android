package com.example.tegb_demo_app.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tegb_demo_app.adapter.ParkingLocationAdapter
import com.example.tegb_demo_app.databinding.FragmentParkingLocationBinding
import com.example.tegb_demo_app.model.response.ParkingLocationResponseModel
import com.example.tegb_demo_app.viewModel.ParkingLocationViewModel

class ParkingLocationFragment : Fragment() {

    private lateinit var binding: FragmentParkingLocationBinding
    private lateinit var promoCodeAdapter: ParkingLocationAdapter
    private lateinit var viewModel: ParkingLocationViewModel
    var promoCodeList = ArrayList<ParkingLocationResponseModel>()
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentParkingLocationBinding.inflate(inflater)

        viewModel = ParkingLocationViewModel()
        prepareRecyclerView()
        binding.shimmerContainer.startShimmer()
        observer()

        getParkingLocation()


        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observer() {
        viewModel.parkingLocationDetail.observe(viewLifecycleOwner) { data ->
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
        promoCodeAdapter = ParkingLocationAdapter()
        binding.rvParkingLocation.apply {
            adapter = promoCodeAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
    private fun getParkingLocation() {
        viewModel.getParkingLocation()
    }
}