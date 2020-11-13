package com.codesroots.osamaomar.shopgate.entities

data class Offer(
    val created: String,
    val end_date: String,
    val id: Int,
    val percentage: String,
    val product_id: Int,
    val start_date: String
)