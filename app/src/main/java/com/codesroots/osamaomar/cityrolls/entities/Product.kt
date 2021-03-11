package com.codesroots.osamaomar.cityrolls.entities

data class Product(
    val id: Int,
    val img: String,
    val name: String,
    val offers: List<Offer>,
    val productsizes: List<Productsize>
)
