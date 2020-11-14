package com.codesroots.osamaomar.shopgate.entities

data class Productdetail(
    val cat_id: Int,
    val description: String,
    val description_en: String,
    val favourites: List<Any>,
    val id: Int,
    val img: String,
    val name: String,
    val name_en: String,
    val offers: List<Any>,
    val product_colors: List<Any>,
    val productphotos: List<Productphoto>,
    val productsizes: List<ProductsizeXX>,
    val subcat_id: Int,
    val total_rating: List<Any>
)