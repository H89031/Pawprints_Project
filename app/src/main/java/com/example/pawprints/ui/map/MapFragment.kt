package com.example.pawprints.ui.map

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pawprints.Chat
import com.example.pawprints.R
import com.example.pawprints.databinding.FragmentMapBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MapFragment : Fragment() {

    private var _binding: FragmentMapBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intent = Intent(requireContext(), Chat::class.java)
        val chatting: ImageButton = view.findViewById(R.id.chat)
        chatting.setOnClickListener {
            startActivity(intent)
        }

        val adoptids = listOf(R.id.adoption1, R.id.adoption2)
        adoptids.forEach { buttonId ->
            val button: ImageButton = view.findViewById(buttonId)
            button.setOnClickListener {
                val bottomSheetDialog = BottomSheetDialog(requireContext())
                val view1 = layoutInflater.inflate(R.layout.map_adoption_popup, null)
                bottomSheetDialog.setContentView(view1)
                bottomSheetDialog.show()
            }
        }
        val clinicids = listOf(R.id.clinic1, R.id.clinic2)
        clinicids.forEach { buttonId ->
            val button: ImageButton = view.findViewById(buttonId)
            button.setOnClickListener {
                val bottomSheetDialog = BottomSheetDialog(requireContext())
                val view1 = layoutInflater.inflate(R.layout.map_clinics_popup, null)
                bottomSheetDialog.setContentView(view1)
                bottomSheetDialog.show()
            }
        }
        val strayids = listOf(R.id.stray1, R.id.stray2)
        strayids.forEach { buttonId ->
            val button: ImageButton = view.findViewById(buttonId)
            button.setOnClickListener {
                val bottomSheetDialog = BottomSheetDialog(requireContext())
                val view1 = layoutInflater.inflate(R.layout.map_strays_popup, null)
                bottomSheetDialog.setContentView(view1)
                bottomSheetDialog.show()
            }
        }
        val missingids = listOf(R.id.missing1, R.id.missing2)
        missingids.forEach { buttonId ->
            val button: ImageButton = view.findViewById(buttonId)
            button.setOnClickListener {
                val bottomSheetDialog = BottomSheetDialog(requireContext())
                val view1 = layoutInflater.inflate(R.layout.map_missing_popup, null)
                bottomSheetDialog.setContentView(view1)
                bottomSheetDialog.show()
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        val mapViewModel =
            ViewModelProvider(this).get(MapViewModel::class.java)

        _binding = FragmentMapBinding.inflate(inflater, container, false)

        val root: View = binding.root
//        val textView: TextView = binding.textNotifications
//        mapViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        return root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}