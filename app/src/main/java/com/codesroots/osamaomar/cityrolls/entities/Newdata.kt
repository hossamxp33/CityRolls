package com.codesroots.osamaomar.cityrolls.entities

data class Newdata(
    val blue: String,
    val cat_id: Int,
    val created: String,
    val description: String,
    val description_en: String,
    val green: String,
    val id: Int,
    val img: String,
    val modified: String,
    val name: String,
    val name_en: String,
    val productsizes: List<Productsize>,
    val red: String,
    val store_id: Int,
    val subcat_id: Int,
    val visible: String
)