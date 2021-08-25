package com.tugas.pgmandroidimam

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class ListBiodata : AppCompatActivity() {

    var adapter: BioAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.biolist)
        supportActionBar!!.title="List Biodata"

        val list = getListBioData()
        val list_data : RecyclerView = findViewById(R.id.list_data)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = BioAdapter(this, list)


        val add_data : CardView = findViewById(R.id.add_data)

        list_data.layoutManager = layoutManager
        list_data.adapter = adapter

        /* Event listener untuk Tambah Biodata
        *
        * */
        add_data.onClick {
            startActivity(intentFor<Biodata>())
        }
    }

private fun showSelectedBio(biodata: BioFormat){
        Toast.makeText(this,"Kamu memilih " + biodata.nama,
        Toast.LENGTH_SHORT).show()
    }


    private fun getListBioData(): List<BioFormat> {
        var listData: List<BioFormat>? = null
        database.use {
            val result = select(BioFormat.TABLE_BIO)
            listData = result.parseList(classParser<BioFormat>())
        }
        return listData!!
    }

    override fun onResume() {
        val list_data : RecyclerView = findViewById(R.id.list_data)
        super.onResume()
        val listRefresh = getListBioData()
        adapter = BioAdapter(this, listRefresh)
        adapter?.notifyDataSetChanged()
        list_data.adapter = adapter
    }
}