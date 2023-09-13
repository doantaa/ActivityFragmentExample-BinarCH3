package com.binar.activityfragmentexample.presentation.fragmentone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.binar.activityfragmentexample.databinding.FragmentOneBinding
import com.binar.activityfragmentexample.model.Person

class FragmentOne : Fragment() {

    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    private fun setClickListener() {
        binding.btnNavigate.setOnClickListener {
            navigateToFragmentTwo()
        }

        binding.btnSendDataNavigate.setOnClickListener {
            navigateToFragmentTwo(getPerson())
        }
    }

    private fun getPerson(): Person? {
        return Person(
            name = "Lee ji eun",
            job = "Singer-songwriter, composer, and actress",
            profileDesc = "Also known by her stage name IU (아이유)",
            profilPictUrl = "https://i.mydramalist.com/W2mRD_5c.jpg"
        )
    }

    private fun navigateToFragmentTwo(person: Person? = null) {
        // USING BUNDLE
        /*        findNavController().navigate(R.id.action_fragmentOne_to_fragmentTwo, Bundle().apply {
                    putParcelable("person", getPerson())
                })*/

        // USING SAFEARGS
        val action = FragmentOneDirections.actionFragmentOneToFragmentTwo(person)
        findNavController().navigate(action)
    }


}