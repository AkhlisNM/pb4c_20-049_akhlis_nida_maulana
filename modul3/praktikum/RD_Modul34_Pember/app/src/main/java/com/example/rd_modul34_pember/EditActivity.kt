package com.example.rd_modul34_pember

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.rd_modul34_pember.data.AppDatabase
import com.example.rd_modul34_pember.data.entity.Club

class EditActivity : AppCompatActivity() {

    private lateinit var clubName: EditText
    private lateinit var julukan: EditText
    private lateinit var stadion: EditText
    private lateinit var btnSave: Button
    private lateinit var database: AppDatabase

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        clubName = findViewById(R.id.club_name)
        julukan = findViewById(R.id.julukan)
        stadion = findViewById(R.id.stadion)
        btnSave = findViewById(R.id.btn_save)

        database = AppDatabase.getInstance(applicationContext)

        var intent = intent.extras
        if (intent!=null){
            var user = database.clubDao().get(intent.getInt("id"))

            clubName.setText(user.clubName)
            julukan.setText(user.julukan)
            stadion.setText(user.stadion)
        }

        btnSave.setOnClickListener {
            if(clubName.text.isNotEmpty() && julukan.text.isNotEmpty() && stadion.text.isNotEmpty()){
                if(intent!=null){
                    // Edit Data
                    database.clubDao().update(
                        Club(
                        intent.getInt("id",0),
                        clubName.text.toString(),
                        julukan.text.toString(),
                        stadion.text.toString()
                    )
                    )
                }
                else{
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

                finish()
            }
            else{
                Toast.makeText(applicationContext,"Data Tidak Diisi Dengan Valid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}