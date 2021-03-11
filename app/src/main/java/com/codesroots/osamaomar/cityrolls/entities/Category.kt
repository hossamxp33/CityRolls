package com.codesroots.osamaomar.cityrolls.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val id: Int,
    val name: String,
    val name_en: String,
    val photo: String,
    val num : String,
    val created: String,
    val modified: String,
    val items: List<Items>
)    : Parcelable {

}