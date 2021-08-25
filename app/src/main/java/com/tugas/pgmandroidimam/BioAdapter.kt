package com.tugas.pgmandroidimam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class BioAdapter(val context: Context, val list: List<BioFormat>)
    : RecyclerView.Adapter<BioAdapter.ViewHolder>(){

   // lateinit var itemview: View

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var itemview: View
        itemview = LayoutInflater.from(context).inflate(R.layout.bioitem, p0, false)
        return ViewHolder(itemview)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(list[p1])
    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(bioFormat: BioFormat) {
            var bio_nama : TextView = itemView.findViewById(R.id.bio_nama)
            var bio_kelamin : TextView = itemView.findViewById(R.id.bio_kelamin)
            var bio_alamat : TextView = itemView.findViewById(R.id.bio_alamat)
            bio_nama.text= bioFormat.id.toString() + " - " + bioFormat.nama
            bio_kelamin.text=bioFormat.tglhr + " - " + bioFormat.jk
            bio_alamat.text=bioFormat.alamat

            itemView.onClick {
                itemView.context.startActivity(itemView.context.intentFor<DetailBiodata>("biodata" to bioFormat))
            }


        }

    }

}