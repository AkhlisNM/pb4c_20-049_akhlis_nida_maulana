package com.example.modul6praktikum

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul6praktikum.data.AppDatabase
import com.example.modul6praktikum.data.Club
import com.example.modul6praktikum.data.UserAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private var list = mutableListOf<Club>()
    private lateinit var adapter: UserAdapter
    private lateinit var database: AppDatabase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_note, container, false)

        recyclerView = rootView.findViewById(R.id.recycler_view)
        fab = rootView.findViewById(R.id.floating_btn)

        database = AppDatabase.getInstance(requireContext())
        adapter = UserAdapter(list)
        adapter.setDialog(object : UserAdapter.Dialog{
            override fun onClick(position: Int) {
                // Membuat dialog view
                val dialog = AlertDialog.Builder(requireContext())
                dialog.setTitle(list[position].clubName)
                dialog.setItems(R.array.pilihan, DialogInterface.OnClickListener{ dialog, which ->
                    if (which==0){
                        // coding ubah
                        val editFragment = EditFragment()
                        val bundle = Bundle()
                        bundle.putInt("id", list[position])
                        editFragment.arguments = bundle

                        val fragmentManager = requireActivity().supportFragmentManager
                        val fragmentTransaction = fragmentManager.beginTransaction()
                        fragmentTransaction.replace(R.id.frame_container, editFragment)
                        fragmentTransaction.addToBackStack(null)
                        fragmentTransaction.commit()

                    }
                    else if (which==1){
                        // coding hapus
                        database.clubDao().delete(list[position])
                        getData()
                    }
                    else{
                        // coding batal
                        dialog.dismiss()
                    }
                })
                // Menampilkan dialog
                val dialogView = dialog.create()
                dialogView.show()
            }
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        fab.setOnClickListener {
            val editFragment = EditFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_container, editFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }


        return rootView
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    private fun getData() {
        list.clear()
        list.addAll(database.clubDao().getAll())
        adapter.notifyDataSetChanged()
    }
}

private fun Bundle.putInt(s: String, club: Club) {

}
