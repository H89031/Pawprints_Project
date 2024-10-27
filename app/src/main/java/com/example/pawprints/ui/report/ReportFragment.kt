package com.example.pawprints.ui.report

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.pawprints.Chat
import com.example.pawprints.R
import com.example.pawprints.databinding.FragmentReportBinding

class ReportFragment : Fragment() {

    private var _binding: FragmentReportBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val seemoreM: TextView = view.findViewById(R.id.seeMoreMissing)
        seemoreM.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_report_to_RMissingDogFragment)        }
        val seemoreS: TextView = view.findViewById(R.id.seeMoreStray)
        seemoreS.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_report_to_RStrayDogFragment)
        }
        val repMDog: TextView = view.findViewById(R.id.reportMDog)
        repMDog.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_report_to_reportMissingFragment)
        }
        val repSDog: TextView = view.findViewById(R.id.reportSDog)
        repSDog.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_report_to_reportStrayFragment)
        }
        ///////////////
        val mdoge1: ImageButton = view.findViewById(R.id.mDog1)
        mdoge1.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_report_to_reportMissingDog1Fragment)
        }
        val mdoge2: ImageButton = view.findViewById(R.id.mDog2)
        mdoge2.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_report_to_reportMissingDog2Fragment)
        }
        val mdoge3: ImageButton = view.findViewById(R.id.mDog3)
        mdoge3.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_report_to_reportMissingDog3Fragment)
        }
        ///////////////
        val sdoge1: ImageButton = view.findViewById(R.id.sDog1)
        sdoge1.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_report_to_reportStrayDog1Fragment)
        }
        val sdoge2: ImageButton = view.findViewById(R.id.sDog2)
        sdoge2.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_report_to_reportStrayDog2Fragment)
        }
        val sdoge3: ImageButton = view.findViewById(R.id.sDog3)
        sdoge3.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_report_to_reportStrayDog3Fragment)
        }
        val intent = Intent(requireContext(), Chat::class.java)
        val chatting: ImageButton = view.findViewById(R.id.chat)
        chatting.setOnClickListener {
            startActivity(intent)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val reportViewModel =
            ViewModelProvider(this).get(ReportViewModel::class.java)

        _binding = FragmentReportBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textNotifications
//        reportViewModel.text.observe(viewLifeCicleOwner){
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}