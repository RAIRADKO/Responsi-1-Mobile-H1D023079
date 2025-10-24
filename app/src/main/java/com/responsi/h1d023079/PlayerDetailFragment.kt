package com.responsi.h1d023079

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View // <-- Pastikan View diimport
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.responsi.h1d023079.databinding.FragmentPlayerDetailBinding

class PlayerDetailFragment(
    private val name: String,
    private val dob: String,
    private val nationality: String,
    private val position: String
) : BottomSheetDialogFragment() {

    private var _binding: FragmentPlayerDetailBinding? = null
    private val binding get() = _binding!!

    override fun getTheme(): Int = R.style.ThemeOverlay_App_BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {
        binding.tvPlayerNameDetail.text = name
        binding.tvPlayerDobDetail.text = dob
        binding.tvPlayerNationalityDetail.text = nationality
        binding.tvPlayerPositionDetail.text = position
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Prevent memory leaks
    }
}