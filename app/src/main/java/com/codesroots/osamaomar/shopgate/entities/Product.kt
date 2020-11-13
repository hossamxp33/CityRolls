package com.codesroots.osamaomar.shopgate.entities

data class Product(
    val id: Int,
    val img: String,
    val name: String,
    val offers: List<Offer>
)