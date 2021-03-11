package com.codesroots.osamaomar.cityrolls.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Items(
    val category_id: Int,

    val id: Int,
    val modified: String,
    val name: String,
    val price: Int,
    val photo: String
)  : Parcelable {

}