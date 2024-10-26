package com.example.pawprints.ui.report

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.pawprints.R
import com.example.pawprints.databinding.FragmentReportBinding

class ReportFragment : Fragment() {

    private var _binding: FragmentReportBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val seemoreM: TextView = view.findViewById(R.id.seeMoreMissing)
        seemoreM.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_report_to_reportMissingFragment)
        }
        val seemoreS: TextView = view.findViewById(R.id.seeMoreStray)
        seemoreS.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_report_to_reportStrayFragment)
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