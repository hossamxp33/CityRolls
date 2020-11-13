package com.codesroots.osamaomar.shopgate.entities

data class Category(
    val created: String,
    val id: Int,
    val modified: String,
    val name: String,
    val name_en: String,
    val number: Int,
    val photo: String,
    val subcats: List<Any>
)