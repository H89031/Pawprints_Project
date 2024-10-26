package com.example.pawprints.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pawprints.Chat
import com.example.pawprints.Navigation
import com.example.pawprints.R
import com.example.pawprints.Signup
import com.example.pawprints.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val posts: ImageButton = view.findViewById(R.id.addpost)
        posts.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_home_to_homeAddPostFragment)
        }

        val Images: ImageView = view.findViewById(R.id.person1)
        Images.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_home_to_homeProfile1Fragment)
        }
        val nameText: TextView = view.findViewById(R.id.name1)
        nameText.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_home_to_homeProfile1Fragment)
        }
        val Images2: ImageView = view.findViewById(R.id.person2)
        Images2.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_home_to_homeProfile2Fragment)
        }
        val nameText2: TextView = view.findViewById(R.id.name2)
        nameText2.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_home_to_homeProfile2Fragment)
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
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.pawprints
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}