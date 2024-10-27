package com.example.pawprints.ui.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.pawprints.Chat
import com.example.pawprints.R
import com.example.pawprints.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val seeAdopt: TextView = view.findViewById(R.id.moreAdopt)
        seeAdopt.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_search_to_searchAdoptionDogsFragment)
        }
        val seeClinic: TextView = view.findViewById(R.id.moreClinic)
        seeClinic.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_search_to_searchClinicsFragment)
        }
        val seeCenter: TextView = view.findViewById(R.id.moreCenter)
        seeCenter.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_search_to_searchAdoptionCenterFragment)
        }
        ///////////////
        val adoge1: ImageButton = view.findViewById(R.id.adoptDog1)
        adoge1.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_search_to_searchDog1Fragment)
        }
        val adoge2: ImageButton = view.findViewById(R.id.adoptDog2)
        adoge2.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_search_to_searchDog2Fragment)
        }
        val adoge3: ImageButton = view.findViewById(R.id.adoptDog3)
        adoge3.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_search_to_searchDog3Fragment)
        }
        ///////////////
        val leclinic1: ImageButton = view.findViewById(R.id.clinics1)
        leclinic1.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_search_to_searchClinic1Fragment)
        }
        val leclinic2: ImageButton = view.findViewById(R.id.clinics2)
        leclinic2.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_search_to_searchClinic2Fragment)
        }
        ///////////////
        val lecenter1: ImageButton = view.findViewById(R.id.centers1)
        lecenter1.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_search_to_searchCenter1Fragment)
        }
        val lecenter2: ImageButton = view.findViewById(R.id.centers2)
        lecenter2.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_search_to_searchCenter2Fragment)
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
        val searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        searchViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}