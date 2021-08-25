package com.tugas.pgmandroidimam

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.db.delete

class DetailBiodata : AppCompatActivity(), View.OnClickListener {

    //lateinit var biodata: BioFormat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.biodetail)
        supportActionBar!!.title="Detail Biodata"
        //var biodata: BioFormat

        //var biodata = intent.getParcelableExtra("biodata")!!
       // Log.d("BIODATA", biodata.toString())
        var det_id : TextView = findViewById(R.id.det_id)
        var det_nama : TextView = findViewById(R.id.det_nama)
        var det_tplhr : TextView = findViewById(R.id.det_tplhr)
        var det_tglhr : TextView = findViewById(R.id.det_tglhr)
        var det_kelamin : TextView = findViewById(R.id.det_kelamin)
        var det_alamat : TextView = findViewById(R.id.det_alamat)
        var det_hobi : TextView = findViewById(R.id.det_hobi)

        var btn_delete : Button = findViewById(R.id.btn_delete)
        var btn_update : Button = findViewById(R.id.btn_update)

//        det_id.text = biodata.id.toString()
//        det_nama.text = biodata.nama
//        det_tplhr.text = biodata.tplhr
//        det_tglhr.text = biodata.tglhr
//        det_kelamin.text = biodata.jk
//        det_alamat.text = biodata.alamat
//        det_hobi.text = biodata.hobi


        btn_delete.setOnClickListener(this)
        btn_update.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var btn_delete : Button = findViewById(R.id.btn_delete)
        var det_id : TextView = findViewById(R.id.det_id)

        //var btn_update : Button = findViewById(R.id.btn_update)
        when(v){
            btn_delete -> deleteData(det_id.toString().toLong())

        }
    }

    private fun deleteData(id: Long?) {
        database.use {
            delete(BioFormat.TABLE_BIO, "${BioFormat.ID} = {id}", "id" to id!!.toInt())
        }
        finish()
    }
}