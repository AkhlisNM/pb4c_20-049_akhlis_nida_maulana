package com.example.modul6praktikum

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val noteFragment = NoteFragment()
                    openFragment(noteFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_save -> {
                    val saveFragment = SaveFragment()
                    openFragment(saveFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_history -> {
                    val historyFragment = HistoryFragment()
                    openFragment(historyFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        // Set NoteFragment as the initial fragment
        val noteFragment = NoteFragment()
        openFragment(noteFragment)
    }
}
