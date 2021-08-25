package com.tugas.pgmandroidimam

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        var btnLogin : CardView = findViewById(R.id.btnLogin)
        var inputUser : TextInputEditText = findViewById(R.id.inputUser)
        var inputPassword : TextInputEditText = findViewById(R.id.inputPassword)
        btnLogin.setOnClickListener {
            val email = inputUser.text.toString()
            val password = inputPassword.text.toString()
            if (email.isEmpty()|| password.isEmpty()) {
                Toast.makeText(this, "Silahkan Masukkan UserName dan Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(email == "admin" && password == "admin"){
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                val progressDialog = ProgressDialog(this,
                    R.style.Theme_MaterialComponents_Light_Dialog)
                progressDialog.isIndeterminate = true
                progressDialog.setMessage("Loading...")
                progressDialog.show()
                val intent = Intent (this,ListBiodata::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Pastikan User dan Password Sudah Benar ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

    }
}