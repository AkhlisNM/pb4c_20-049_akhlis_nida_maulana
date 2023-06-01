package com.example.rd_modul34_pember

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rd_modul34_pember.adapter.UserAdapter
import com.example.rd_modul34_pember.data.AppDatabase
import com.example.rd_modul34_pember.data.entity.Club
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private var list = mutableListOf<Club>()
    private lateinit var adapter: UserAdapter
    private lateinit var database: AppDatabase

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        recyclerView = findViewById(R.id.recycler_view)
        fab = findViewById(R.id.floating_btn)

        database = AppDatabase.getInstance(applicationContext)
        adapter = UserAdapter(list)
        adapter.setDialog(object : UserAdapter.Dialog{
            override fun onClick(position: Int) {
                // Membuat dialog view
                val dialog = AlertDialog.Builder(this@NoteActivity)
                dialog.setTitle(list[position].clubName)
                dialog.setItems(R.array.pilihan, DialogInterface.OnClickListener{ dialog, which ->
                    if (which==0){
                        // coding ubah
                        val intent = Intent(this@NoteActivity, EditActivity::class.java)
                        intent.putExtra("id", list[position].id)
                        startActivity(intent)
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
        recyclerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        recyclerView.addItemDecoration(
            DividerItemDecoration(applicationContext,
                RecyclerView.VERTICAL
            )
        )

        fab.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    fun getData(){
        list.clear()
        list.addAll(database.clubDao().getAll())
        adapter.notifyDataSetChanged()
    }
}