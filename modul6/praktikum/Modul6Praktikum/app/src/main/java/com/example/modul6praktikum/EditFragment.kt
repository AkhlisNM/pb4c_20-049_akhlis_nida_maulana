package com.example.modul6praktikum

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.modul6praktikum.data.AppDatabase
import com.example.modul6praktikum.data.Club

class EditFragment : Fragment() {
    private lateinit var clubName: EditText
    private lateinit var julukan: EditText
    private lateinit var stadion: EditText
    private lateinit var btnSave: Button
    private lateinit var database: AppDatabase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_edit, container, false)

        clubName = rootView.findViewById(R.id.club_name)
        julukan = rootView.findViewById(R.id.julukan)
        stadion = rootView.findViewById(R.id.stadion)
        btnSave = rootView.findViewById(R.id.btn_save)

        database = AppDatabase.getInstance(requireContext())

        val intent = requireActivity().intent
        if (intent != null && intent.hasExtra("id")) {
            val id = intent.getIntExtra("id", 0)
            val user = database.clubDao().get(id)

            if (user != null) {
                clubName.setText(user.clubName)
                julukan.setText(user.julukan)
                stadion.setText(user.stadion)
            } else {
                // Handle case when user is null or not found
            }
        }


        btnSave.setOnClickListener {
            if (clubName.text.isNotEmpty() && julukan.text.isNotEmpty() && stadion.text.isNotEmpty()) {
                if (intent != null && intent.hasExtra("id")) {
                    val id = intent.getIntExtra("id", 0)
                    val user = database.clubDao().get(id)

                    if (user != null) {
                        user.clubName = clubName.text.toString()
                        user.julukan = julukan.text.toString()
                        user.stadion = stadion.text.toString()

                        database.clubDao().update(user)
                    } else {
                        // Handle case when user is null or not found
                    }
                } else {
                    // Tambah Data
                    database.clubDao().insertAll(
                        Club(
                            null,
                            clubName.text.toString(),
                            julukan.text.toString(),
                            stadion.text.toString()
                        )
                    )
                }

                requireActivity().finish()
            } else {
                Toast.makeText(requireContext(), "Data Tidak Diisi Dengan Valid", Toast.LENGTH_SHORT).show()
            }
        }

        return rootView
    }
}
