package com.cepotdev.nloer

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAngkringanAdapter(private val listAngkringan: ArrayList<Angkringan>): RecyclerView.Adapter<ListAngkringanAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_card, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int  = listAngkringan.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listAngkringan[position]
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.ivPhoto.setImageResource(photo)

        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_angkringan", listAngkringan[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPhoto: ImageView = itemView.findViewById(R.id.iv_foto)
        val tvName: TextView = itemView.findViewById(R.id.tv_nama)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_deskripsi)

    }

}