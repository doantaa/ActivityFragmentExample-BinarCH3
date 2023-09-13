package com.binar.activityfragmentexample.presentation.fragmenttwo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.binar.activityfragmentexample.R
import com.binar.activityfragmentexample.databinding.FragmentTwoBinding
import com.binar.activityfragmentexample.model.Person

class FragmentTwo : Fragment() {

    private lateinit var binding: FragmentTwoBinding
    private val person: Person? by lazy {
        //bundle arguments
        //arguments?.getParcelable("person")

        FragmentTwoArgs.fromBundle(arguments as Bundle).person
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
        showProfileData()
    }

    private fun showProfileData() {
        if (person != null) {
            binding.llProfile.isVisible = true
            binding.ivProfileImg.load(person?.profilPictUrl)
            binding.tvName.text = person?.name
            binding.tvJob.text = person?.job
            binding.tvProfileDesc.text = person?.profileDesc
        } else {
            Toast.makeText(context, "Profile is Null", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setClickListener() {
        binding.btnNavigate.setOnClickListener {
            navigateToFragmentThree()
        }
    }

    private fun navigateToFragmentThree() {
        findNavController().navigate(R.id.action_fragmentTwo_to_fragmentThree)
    }

}