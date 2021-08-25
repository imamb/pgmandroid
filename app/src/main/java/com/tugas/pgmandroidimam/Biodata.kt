package com.tugas.pgmandroidimam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class Biodata : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.biodata)
        supportActionBar!!.title="Tambah Biodata"

        val btnSimpan : CardView = findViewById(R.id.btnSimpan)


        btnSimpan.onClick {
            if (!validation()){
                return@onClick
            }
            insertDatabase()
        }

    }

    private fun insertDatabase() {
        val inputNama : TextInputEditText = findViewById(R.id.inputNama)
        val inputTempat : TextInputEditText = findViewById(R.id.inputTempat)
        val inputTanggal : TextInputEditText = findViewById(R.id.inputTanggal)
        val inputKelamin : TextInputEditText = findViewById(R.id.inputKelamin)
        val inputAlamat : TextInputEditText = findViewById(R.id.inputAlamat)
        val inputHobi : TextInputEditText = findViewById(R.id.inputHobi)

        database.use {
            insert(BioFormat.TABLE_BIO,
                BioFormat.NAMA to inputNama.text.toString(),
                BioFormat.TPLHR to inputTempat.text.toString(),
                BioFormat.TGLHR to inputTanggal.text.toString(),
                BioFormat.JK to inputKelamin.text.toString(),
                BioFormat.ALAMAT to inputAlamat.text.toString(),
                BioFormat.HOBI to inputHobi.text.toString(),
                BioFormat.PHOTO to null
            )

         toast("Berhasil menambah biodata baru")
        }
    }

    private fun validation(): Boolean{
        val inputNama : TextInputEditText = findViewById(R.id.inputNama)
        val inputTempat : TextInputEditText = findViewById(R.id.inputTempat)
        val inputTanggal : TextInputEditText = findViewById(R.id.inputTanggal)
        val inputKelamin : TextInputEditText = findViewById(R.id.inputKelamin)
        val inputAlamat : TextInputEditText = findViewById(R.id.inputAlamat)
        val inputHobi : TextInputEditText = findViewById(R.id.inputHobi)

        when {
            inputNama.text.toString().isBlank() -> {
                inputNama.requestFocus()
                inputNama.error = "Tidak boleh kosong"
                return false
            }
            inputTempat.text.toString().isBlank() -> {
                inputTempat.requestFocus()
                inputTempat.error = "Tidak boleh kosong"
                return false
            }
            inputTanggal.text.toString().isBlank() -> {
                inputTanggal.requestFocus()
                inputTanggal.error = "Tidak boleh kosong"
                return false
            }
            inputKelamin.text.toString().isBlank() -> {
                inputKelamin.requestFocus()
                inputKelamin.error = "Tidak boleh kosong"
                return false
            }
            inputAlamat.text.toString().isBlank() -> {
                inputAlamat.requestFocus()
                inputAlamat.error = "Tidak boleh kosong"
                return false
            }
            inputHobi.text.toString().isBlank() -> {
                inputHobi.requestFocus()
                inputHobi.error = "Tidak boleh kosong"
                return false
            }
            else -> return true
        }

    }
}