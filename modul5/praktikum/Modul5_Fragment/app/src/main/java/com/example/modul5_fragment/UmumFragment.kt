package com.example.modul5_fragment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class UmumFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_umum, container, false)
    }

    @SuppressLint("StringFormatInvalid")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvImage2: ImageView= view.findViewById(R.id.imageView)
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)

        tvImage2.setImageResource(R.drawable.konten)
    }

    companion object {
        const val ARG_SECTION_NUMBER = "section_number"
    }
}