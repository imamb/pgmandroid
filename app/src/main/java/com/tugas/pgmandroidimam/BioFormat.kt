package com.tugas.pgmandroidimam

import android.os.Parcel
import android.os.Parcelable

@Parcelize
data class BioFormat(
        val id: Long?,
        val nama: String?,
        val tplhr: String?,
        val tglhr: String?,
        val jk: String?,
        val alamat: String?,
        val hobi: String?,
        val photo: String?
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        id = parcel.readValue(Long::class.java.classLoader) as? Long,
        nama = parcel.readString(),
        tplhr = parcel.readString(),
        tglhr = parcel.readString(),
        jk = parcel.readString(),
        alamat = parcel.readString(),
        hobi = parcel.readString(),
        photo = parcel.readString()
    ) {
    }

    companion object{
            const val TABLE_BIO = "table_bio"
            const val ID = "id"
            const val NAMA = "nama"
            const val TPLHR = "tplhr"
            const val TGLHR = "tglhr"
            const val JK = "jk"
            const val ALAMAT = "alamat"
            const val HOBI = "hobi"
            const val PHOTO = "photo"
        }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(nama)
        parcel.writeString(tplhr)
        parcel.writeString(tglhr)
        parcel.writeString(jk)
        parcel.writeString(alamat)
        parcel.writeString(hobi)
        parcel.writeString(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

//    companion object CREATOR : Parcelable.Creator<BioFormat> {
//        override fun createFromParcel(parcel: Parcel): BioFormat {
//            return BioFormat(parcel)
//        }
//
//        override fun newArray(size: Int): Array<BioFormat?> {
//            return arrayOfNulls(size)
//        }
//    }
}

annotation class Parcelize
