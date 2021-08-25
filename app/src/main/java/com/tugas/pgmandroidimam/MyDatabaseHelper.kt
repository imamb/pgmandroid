package com.tugas.pgmandroidimam

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import java.sql.Types.DATE

class MyDatabaseHelper(context: Context) : ManagedSQLiteOpenHelper(context, "database_student.db", null, 1) {

    companion object {
        private var instance: MyDatabaseHelper? = null

        fun getInstance(context: Context): MyDatabaseHelper {
            if (instance == null) {
                instance = MyDatabaseHelper(context)
            }
            return instance as MyDatabaseHelper
        }

    }

    override fun onCreate(db: SQLiteDatabase?) {
        //Buat tabel pada database
        db?.createTable(
            BioFormat.TABLE_BIO,
            true,
            BioFormat.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            BioFormat.NAMA to TEXT,
            BioFormat.TPLHR to TEXT,
            BioFormat.TGLHR to TEXT,
            BioFormat.JK to TEXT,
            BioFormat.ALAMAT to TEXT,
            BioFormat.HOBI to TEXT,
            BioFormat.PHOTO to TEXT

        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(BioFormat.TABLE_BIO, true)
    }
}

val Context.database: MyDatabaseHelper
    get() = MyDatabaseHelper(applicationContext)