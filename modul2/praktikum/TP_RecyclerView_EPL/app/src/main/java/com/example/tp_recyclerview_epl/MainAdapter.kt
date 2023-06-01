package com.example.tp_recyclerview_epl

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    private val getActivity: MainActivity,
    private val clubList : List<Data>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.nama.text = clubList[position].club
        holder.julukan.text = clubList[position].alias
        holder.gambar.setImageResource(clubList[position].gambar)

        holder.cardView.setOnClickListener {
            Toast.makeText(getActivity,clubList[position].club, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return clubList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nama : TextView = itemView.findViewById(R.id.namaClub)
        val julukan : TextView = itemView.findViewById(R.id.julukanClub)
        val gambar : ImageView = itemView.findViewById(R.id.gambar)
        val cardView : CardView = itemView.findViewById(R.id.cardView)
    }
}