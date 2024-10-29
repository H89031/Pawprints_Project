package com.example.pawprints.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.pawprints.Chat
import com.example.pawprints.R
import java.sql.Types.NULL

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeProfile2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeProfile2Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val followed = mutableMapOf<Int, Boolean>()
    private val liked = mutableMapOf<Int, Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intent = Intent(requireContext(), Chat::class.java)
        val chatting: ImageButton = view.findViewById(R.id.chat)
        chatting.setOnClickListener {
            startActivity(intent)
        }
        val follow = listOf(
            view.findViewById<TextView>(R.id.prof2follow),
            view.findViewById<TextView>(R.id.prof2FollowText1),
            view.findViewById<TextView>(R.id.prof2FollowText2)
        )
        val followbtn = view.findViewById<TextView>(R.id.prof2follow)
        val followtxt1 = view.findViewById<TextView>(R.id.prof2FollowText1)
        val followtxt2 = view.findViewById<TextView>(R.id.prof2FollowText2)
        val count = view.findViewById<TextView>(R.id.prof2count)

        follow.forEach { textView ->
            followed[textView.id] = false
        }
        //prof2FollowText
        //android:id="@id/prof2Follow"
        follow.forEach { textView ->
            textView.setOnClickListener {
                val isFollowed = followed[textView.id] ?: false

                if (!isFollowed) {
                    followbtn.setBackgroundResource(R.drawable.f_rounded_grey)
                    followbtn.setText("followed")
                    followed[textView.id] = true
                    followtxt1.setText("followed")
                    followtxt1.setTextColor(ContextCompat.getColor(requireContext(), R.color.purple))
                    followtxt2.setText("followed")
                    followtxt2.setTextColor(ContextCompat.getColor(requireContext(), R.color.purple))
                    count.setText("64")

                } else {
                    followbtn.setBackgroundResource(R.drawable.f_rounded_purple)
                    followbtn.setText("follow")
                    followed[textView.id] = false
                    followtxt1.setText("follow")
                    followtxt1.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                    followtxt2.setText("follow")
                    followtxt2.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                    count.setText("63")

                }
            }
            val like1: ImageButton = view.findViewById(R.id.prof2heart1)
            val like2: ImageButton = view.findViewById(R.id.prof2heart2)

            liked[R.id.prof2heart1] = false
            liked[R.id.prof2heart2] = false
            like1.setOnClickListener {
                if( liked[R.id.prof2heart1]== false){
                    like1.setImageResource(R.drawable.ic_icon_heart_clicked)
                    liked[R.id.prof2heart1] = true
                }
                else{
                    like1.setImageResource(R.drawable.ic_icon_heart)
                    liked[R.id.prof2heart1] = false
                }
            }
            like2.setOnClickListener {
                if( liked[R.id.prof2heart2]== false){
                    like2.setImageResource(R.drawable.ic_icon_heart_clicked)
                    liked[R.id.prof2heart2] = true
                }
                else{
                    like2.setImageResource(R.drawable.ic_icon_heart)
                    liked[R.id.prof2heart2] = false
                }
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_profile2, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeProfile2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeProfile2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}