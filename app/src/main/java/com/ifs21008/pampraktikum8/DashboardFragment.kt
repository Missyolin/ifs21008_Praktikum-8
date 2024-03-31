package com.ifs21008.pampraktikum8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ifs21008.pampraktikum8.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.apply {
//            svFragmentDashboard.setupWithSearchBar(sbFragmentDashboard)
//            svFragmentDashboard
//                .editText
//                .setOnEditorActionListener { textView, actionId, event ->
//                    sbFragmentDashboard.setText(svFragmentDashboard.text)
//                    svFragmentDashboard.hide()
//
//                    val message =
//                        "Kamu mencari dengan keywords:\n${svFragmentDashboard.text}"
//
//                    Toast.makeText(
//                        requireContext(),
//                        message,
//                        Toast.LENGTH_LONG
//                    ).show()
//                    false
//                }
//        }

    }
}