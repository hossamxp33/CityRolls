package com.codesroots.osamaomar.shopgate.entities

data class Related(
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
    val productphotos: List<ProductphotoX>,
    val productsizes: List<ProductsizeXXX>,
    val red: String,
    val store_id: Int,
    val subcat_id: Int,
    val total_rating: List<Any>,
    val visible: String
)