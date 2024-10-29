package com.example.pawprints.ui.map

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.pawprints.Chat
import com.example.pawprints.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.sql.Types.NULL

class GMaps : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        // Add markers with titles to differentiate them
        googleMap.addMarker(
            MarkerOptions().position(LatLng(14.752254549381146, 121.04564738516163))
                .title("Pawssion Project Adoption Center").icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromDrawable(R.drawable.ic_pin_center)!!))
        )

        googleMap.addMarker(
            MarkerOptions().position(LatLng(14.73296559156871, 121.06497226915262))
                .title("Regalado Veterinary Clinic").icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromDrawable(R.drawable.ic_pin_clinic)!!))
        )
        googleMap.addMarker(
            MarkerOptions().position(LatLng(14.740007507573043, 121.05083130945665))
                .title("Missing Dog").icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromDrawable(R.drawable.ic_pin_missing)!!))
        )

        googleMap.addMarker(
            MarkerOptions().position(LatLng(14.726398898442062, 121.05905437287026))
                .title("Stray Dog").icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromDrawable(R.drawable.ic_pin_stray)!!))
        )
        googleMap.addMarker(
            MarkerOptions().position(LatLng(14.723104954883974, 121.0430402734264))
                .title("Pawssion Project Adoption Center").icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromDrawable(R.drawable.ic_pin_center)!!))
        )

        googleMap.addMarker(
            MarkerOptions().position(LatLng(14.73016829005084, 121.04900097268691))
                .title("Regalado Veterinary Clinic").icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromDrawable(R.drawable.ic_pin_clinic)!!))
        )
        googleMap.addMarker(
            MarkerOptions().position(LatLng(14.724187494606497, 121.06346788226035))
                .title("Missing Dog").icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromDrawable(R.drawable.ic_pin_missing)!!))
        )

        googleMap.addMarker(
            MarkerOptions().position(LatLng(14.739078393300986, 121.06753943951306))
                .title("Stray Dog").icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromDrawable(R.drawable.ic_pin_stray)!!))
        )

        googleMap.moveCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(
                    14.733112574046231, 121.0604805835635
                ), 13f
            )
        )

        // Set custom InfoWindowAdapter
        googleMap.setInfoWindowAdapter(CustomInfoWindowAdapter())
    }

    private fun getBitmapFromDrawable(resId: Int): Bitmap? {
        var bitmap: Bitmap? = null
        val drawable = ResourcesCompat.getDrawable(resources, resId, null)
        if (drawable != null) {
            bitmap = Bitmap.createBitmap(125, 125, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)
        }
        return bitmap
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_g_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intent = Intent(requireContext(), Chat::class.java)
        val chatting: ImageButton = view.findViewById(R.id.chat)
        chatting.setOnClickListener {
            startActivity(intent)
        }
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    enum class IconType {
        STAR,
        CHECK,
        NONE
    }


    inner class CustomInfoWindowAdapter : GoogleMap.InfoWindowAdapter {

        override fun getInfoContents(marker: Marker): View? {
            // Determine which layout to use based on the marker title
            val infoWindowView = when (marker.title) {
                "Pawssion Project Adoption Center" -> {
                    val view = layoutInflater.inflate(R.layout.marker1_panel, null)

                    // Initialize views for the first layout
                    val titleTextView = view.findViewById<TextView>(R.id.info_window_title)
                    val imageView = view.findViewById<ImageView>(R.id.info_window_image)
                    val locationTextView = view.findViewById<TextView>(R.id.info_window_location)
                    val phoneTextView = view.findViewById<TextView>(R.id.info_window_phonenumber)
                    val emailTextView = view.findViewById<TextView>(R.id.info_window_email)
                    val tagContainer = view.findViewById<LinearLayout>(R.id.tagContainer)

                    // Set values for the first marker
                    titleTextView.text = marker.title
                    imageView.setImageResource(R.drawable.ad_pawssion_project)
                    locationTextView.text = "Camarin, Caloocan City"
                    phoneTextView.text = "0917 123 4567"
                    emailTextView.text = "pawssionproject123@gmail.com"

                    // Add tag for this marker
                    addTag(tagContainer, "Rating: 4.8", IconType.STAR)

                    view // Return the inflated view
                }

                "Regalado Veterinary Clinic" -> {
                    val view = layoutInflater.inflate(R.layout.marker1_panel, null)

                    // Initialize views for the second layout
                    val titleTextView = view.findViewById<TextView>(R.id.info_window_title)
                    val imageView = view.findViewById<ImageView>(R.id.info_window_image)
                    val locationTextView = view.findViewById<TextView>(R.id.info_window_location)
                    val phoneTextView = view.findViewById<TextView>(R.id.info_window_phonenumber)
                    val emailTextView = view.findViewById<TextView>(R.id.info_window_email)
                    val tagContainer = view.findViewById<LinearLayout>(R.id.tagContainer)

                    // Set values for the second marker
                    titleTextView.text = marker.title
                    imageView.setImageResource(R.drawable.ac_regalado)
                    locationTextView.text = "Regalado Avenue, Fairview, Q.C"
                    phoneTextView.text = "8823 9876"
                    emailTextView.text = "regaladovet@gmail.com"

                    // Add multiple tags for this marker
                    addTag(tagContainer, "Check-Up", IconType.CHECK)
                    addTag(tagContainer, "Grooming", IconType.CHECK)
                    addTag(tagContainer, "Castration & Spaying", IconType.CHECK)

                    view // Return the inflated view
                }
                "Missing Dog" -> {
                    val view = layoutInflater.inflate(R.layout.marker2_panel, null)

                    // Initialize views for the second layout
                    val titleTextView = view.findViewById<TextView>(R.id.info_window_title)
                    val imageView = view.findViewById<ImageView>(R.id.info_window_image)
                    //val topright = view.findViewById<TextView>(R.id.info_window_topright)
                    //val topleft = view.findViewById<TextView>(R.id.info_window_topleft)
                    //val bottomleft = view.findViewById<TextView>(R.id.info_window_bottomleft)
                    //val bottomright = view.findViewById<TextView>(R.id.info_window_bottomright)
                    val tagContainer = view.findViewById<LinearLayout>(R.id.tagContainer)
                    val labelcontainer = view.findViewById<LinearLayout>(R.id.LabelContainer1)
                    val labelcontainer2 = view.findViewById<LinearLayout>(R.id.LabelContainer2)

                    // Set values for the second marker
                    titleTextView.text = marker.title
                    imageView.setImageResource(R.drawable.miss_princess)
                    //topright.text = "Regalado Avenue, Fairview, Q.C"
                    //topleft.text = "Name : Princess"
                    //bottomleft.text =  "Sex : Female"
                    //bottomright.text = "Breed : Shih Tzu"

                    // Add multiple tags for this marker
                    addTag(tagContainer, "Last seen at Fairview, Quezon City on October 24, 2024", IconType.NONE)
                    addLabel(labelcontainer, "Name : Princess")
                    addLabel(labelcontainer, "Age : 2 years old")
                    addLabel(labelcontainer2, "Sex : Female")
                    addLabel(labelcontainer2, "Breed : Shih Tzu")
                    view // Return the inflated view
                }
                "Stray Dog" -> {
                    val view = layoutInflater.inflate(R.layout.marker2_panel, null)

                    // Initialize views for the second layout
                    val titleTextView = view.findViewById<TextView>(R.id.info_window_title)
                    val imageView = view.findViewById<ImageView>(R.id.info_window_image)
                    //val topright = view.findViewById<TextView>(R.id.info_window_topright)
                    //val topleft = view.findViewById<TextView>(R.id.info_window_topleft)
                    //val bottomleft = view.findViewById<TextView>(R.id.info_window_bottomleft)
                    //val bottomright = view.findViewById<TextView>(R.id.info_window_bottomright)
                    val tagContainer = view.findViewById<LinearLayout>(R.id.tagContainer)
                    val labelcontainer = view.findViewById<LinearLayout>(R.id.LabelContainer1)
                    val labelcontainer2 = view.findViewById<LinearLayout>(R.id.LabelContainer2)

                    // Set values for the second marker
                    titleTextView.text = marker.title
                    imageView.setImageResource(R.drawable.bogart)
                    //topright.text = "Sex : Male"
                    //topleft.text = "Given Name : Bogart"
                    //bottomleft.text = "Brown Aspin with thick, hairy fur."

                    // Add multiple tags for this marker
                    addTag(
                        tagContainer,
                        "Last seen at Fairview, Quezon City on October 24, 2024",
                        IconType.NONE
                    )
                    addLabel(labelcontainer, "Sex : Male")
                    addLabel(labelcontainer, "Given Name : Bogart")
                    addLabel(labelcontainer2, "Brown Aspin with thick, hairy fur.")

                    view // Return the inflated view
                }

                else -> {
                    val view = layoutInflater.inflate(R.layout.marker1_panel, null)

                    // Fallback for unknown location
                    val titleTextView = view.findViewById<TextView>(R.id.info_window_title)
                    val imageView = view.findViewById<ImageView>(R.id.info_window_image)
                    val locationTextView = view.findViewById<TextView>(R.id.info_window_location)
                    val phoneTextView = view.findViewById<TextView>(R.id.info_window_phonenumber)
                    val emailTextView = view.findViewById<TextView>(R.id.info_window_email)

                    titleTextView.text = "Unknown Location"
                    imageView.setImageResource(R.drawable.miss_alby)
                    locationTextView.text = "NONE"
                    phoneTextView.text = "NONE"
                    emailTextView.text = "NONE"

                    view // Return the inflated view
                }
            }

            return infoWindowView // Return the selected info window view
        }

        override fun getInfoWindow(marker: Marker): View? {
            return null // Use default window
        }
        var leftOrRight = 0

        private fun addLabel(layout: LinearLayout, label: String) {
            // Reset leftOrRight after two calls
                leftOrRight = 0

            // Create a new LinearLayout for the label
            val tagLayout = LinearLayout(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    0, // Width set to 0 to allow weight to distribute space
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    marginEnd = 4 // Space between tags
                    weight = 1f // Set weight to 1 for equal space distribution
                }
                orientation = LinearLayout.HORIZONTAL
                gravity = if (leftOrRight == 0) {
                    Gravity.START // Align left
                } else {
                    Gravity.END   // Align right
                }
                leftOrRight += 1 // Toggle alignment
                setPadding(5, 5, 5, 5)
                setBackgroundColor(ResourcesCompat.getColor(resources, R.color.white, null))
            }

            // Create the TextView for the label
            val tagTextView = TextView(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    marginEnd = 8 // Space between text and icon
                }
                text = label
                setTextColor(Color.parseColor("#555555"))
                textSize = 14f
                setPadding(4, 2, 4, 2)
            }

            // Add the TextView to the tag layout
            tagLayout.addView(tagTextView)

            // Add the tag layout to the main container
            layout.addView(tagLayout)
        }

        private fun addTag(container: LinearLayout, tagName: String, iconType: IconType) {
            // Create a new LinearLayout for the tag
            val tagLayout = LinearLayout(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    marginEnd = 8 // Space between tags
                }
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL // Align items vertically centered
                setPadding(5, 5, 5, 5)
                background = ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.rounded_blue,
                    null
                )
            }

            // Create the TextView for the tag name
            val tagTextView = TextView(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    marginEnd = 4 // Space between text and icon
                }
                text = tagName
                setTextColor(Color.WHITE)
                textSize = 11f
                setPadding(4, 2, 4, 2)

            }

            // Create the ImageView for the icon
            val iconImageView = ImageView(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    32, // Width of the icon
                    32  // Height of the icon
                ).apply {
                    marginStart = 4 // Space between TextView and ImageView
                }
                adjustViewBounds = true
                scaleType = ImageView.ScaleType.CENTER_INSIDE // Ensures the image scales properly

                // Set the icon based on the iconType
                when (iconType) {
                    IconType.STAR -> {
                        setImageResource(R.drawable.ic_icon_star_white)
                    }
                    IconType.CHECK -> {
                        setImageResource(R.drawable.ic_icon_check)
                    }
                    IconType.NONE -> {
                        setImageResource(0)
                    }
                }
            }

            // Add the TextView and ImageView to the tag layout
            tagLayout.addView(tagTextView)
            tagLayout.addView(iconImageView)

            // Add the tag layout to the container
            container.addView(tagLayout)
        }
    }
}