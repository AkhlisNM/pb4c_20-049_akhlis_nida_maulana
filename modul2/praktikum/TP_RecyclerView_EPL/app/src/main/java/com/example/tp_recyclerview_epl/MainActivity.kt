package com.example.tp_recyclerview_epl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {

    private var mainAdapter : MainAdapter?=null
    private var recyclerView : RecyclerView?=null
    private var clubList = mutableListOf<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clubList = ArrayList()

        recyclerView = findViewById<View>(R.id.rvClub) as RecyclerView
        mainAdapter = MainAdapter(this@MainActivity,clubList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = mainAdapter

        prepareClubList()

    }

    private fun prepareClubList() {
        var club = Data("Arsenal", "The Gunners",R.drawable.arsenal)
        clubList.add(club)
        club = Data("Aston Villa", "The Villans",R.drawable.aston)
        clubList.add(club)
        club = Data("Manchester United", "The Red Devils",R.drawable.emyu)
        clubList.add(club)
        club = Data("Everton", "The Toffes",  R.drawable.Everton)
        clubList.add(club)
        club = Data("Arsenal", "The Gunners",R.drawable.arsenal)
        clubList.add(club)
        club = Data("Aston Villa", "The Villans",R.drawable.aston)
        clubList.add(club)
        club = Data("Manchester United", "The Red Devils",R.drawable.emyu)
        clubList.add(club)
        club = Data("Everton", "The Toffes",R.drawable.Everton)
        clubList.add(club)
        club = Data("Arsenal", "The Gunners",R.drawable.arsenal)
        clubList.add(club)
        club = Data("Aston Villa", "The Villans",R.drawable.aston)
        clubList.add(club)
        club = Data("Manchester United", "The Red Devils",R.drawable.emyu)
        clubList.add(club)
        club = Data("Everton", "The Toffes",R.drawable.Everton)
        clubList.add(club)
        club = Data("Arsenal", "The Gunners",R.drawable.arsenal)
        clubList.add(club)
        club = Data("Aston Villa", "The Villans",R.drawable.aston)
        clubList.add(club)
        club = Data("Manchester United", "The Red Devils",R.drawable.emyu)
        clubList.add(club)
        club = Data("Everton", "The Toffes",R.drawable.Everton)
        clubList.add(club)
        club = Data("Arsenal", "The Gunners",R.drawable.arsenal)
        clubList.add(club)
        club = Data("Aston Villa", "The Villans",R.drawable.aston)
        clubList.add(club)
        club = Data("Manchester United", "The Red Devils",R.drawable.emyu)
        clubList.add(club)
        club = Data("Everton", "The Toffes",R.drawable.Everton)
        clubList.add(club)


        mainAdapter!!.notifyDataSetChanged()
    }
}