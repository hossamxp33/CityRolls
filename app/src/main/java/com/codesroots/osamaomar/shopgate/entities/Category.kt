package com.codesroots.osamaomar.shopgate.entities

data class Category(
    val id: Int,
    val name: String,
    val name_en: String,
    val photo: String,
    val num : String,
    val created: String,
    val modified: String,
    val subcats: List<Subcat>
)