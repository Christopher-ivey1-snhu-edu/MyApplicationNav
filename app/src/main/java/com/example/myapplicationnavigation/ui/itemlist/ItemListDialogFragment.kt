package com.example.myapplicationnavigation.ui.itemlist

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationnavigation.R
import com.example.myapplicationnavigation.databinding.FragmentItemListDialogListDialogItemBinding
import com.example.myapplicationnavigation.databinding.FragmentItemListDialogListDialogBinding

class ItemListDialogFragment : Fragment() {

    private var _binding: FragmentItemListDialogListDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemListDialogListDialogBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[ItemListViewModel::class.java]

        viewModel.people.observe(viewLifecycleOwner) {
            binding.result.text = it.joinToString()
        }

        viewModel.getPeople()
    }
}