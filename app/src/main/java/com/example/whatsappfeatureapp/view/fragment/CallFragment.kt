package com.example.whatsappfeatureapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsappfeatureapp.R
import com.example.whatsappfeatureapp.databinding.FragmentCallBinding
import com.example.whatsappfeatureapp.model.Call
import com.example.whatsappfeatureapp.view.adapter.CallAdapter
import java.util.*

class CallFragment : Fragment() {
    private lateinit var binding: FragmentCallBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCallBinding.inflate(inflater, container, false)
        testCallAdapter()
        return binding.root
    }

    private fun testCallAdapter() {
        val callItemList = ArrayList<Call>()
        callItemList.apply {
            add(
                Call("Name1", true,
                    Date(123, 0, 21, 10, 30, 25 ),
                    0, false,  R.drawable.actor1)
            )
            add(
                Call("Name2", false,
                    Date(123, 0, 25, 10, 30, 25 ),
                    1, true,  R.drawable.actor1)
            )
            add(
                Call("Name3", true,
                    Date(123, 0, 27, 10, 30, 25 ),
                    3, true,  R.drawable.actor1)
            )
            add(
                Call("Name4", false,
                    Date(123, 1, 1, 10, 30, 25 ),
                    3, false,  R.drawable.actor1)
            )
            add(
                Call("Name5", true,
                    Date(123, 1, 3, 10, 30, 25 ),
                    5, true,  R.drawable.actor1)
            )
            add(
                Call("Name6", false,
                    Date(123, 1, 5, 10, 30, 25 ),
                    1, true,  R.drawable.actor1)
            )
            add(
                Call("Name7", true,
                    Date(123, 1, 6, 1, 28, 30 ),
                    2, false,  R.drawable.actor1)
            )
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = CallAdapter(requireContext(), callItemList)
    }
}