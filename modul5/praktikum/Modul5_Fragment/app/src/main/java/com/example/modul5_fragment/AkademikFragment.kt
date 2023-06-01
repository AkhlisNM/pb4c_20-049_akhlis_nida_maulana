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

class AkademikFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_akademik, container, false)
    }

    @SuppressLint("StringFormatInvalid")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvImage: ImageView= view.findViewById(R.id.gambar_edl)
        val tvLabel: TextView = view.findViewById(R.id.p1)
        val tvLabel2: TextView = view.findViewById(R.id.p2)
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)

        tvImage.setImageResource(R.drawable.edlink)
        tvLabel.text = getString(R.string.content_akademik, index)
        tvLabel2.text = getString(R.string.content_akademik2, index)
    }

    companion object {
        const val ARG_SECTION_NUMBER = "section_number"
    }
}

