package com.binar.activityfragmentexample.presentation.fragmentthree

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binar.activityfragmentexample.R
import com.binar.activityfragmentexample.databinding.FragmentThreeBinding
import com.binar.activityfragmentexample.presentation.otheractivity.OtherActivity

class FragmentThree : Fragment() {

    private lateinit var binding: FragmentThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    private fun setClickListener() {
        binding.btnNavigateOther.setOnClickListener{
            navigateToOtherActivity()
        }
    }

    private fun navigateToOtherActivity() {
        OtherActivity.startActivity(requireContext(), "Doanta", 19)
    }
}