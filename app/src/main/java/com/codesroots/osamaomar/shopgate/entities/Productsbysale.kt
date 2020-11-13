package com.codesroots.osamaomar.shopgate.entities

data class Productsbysale(
    val amount: Int,
    val created: String,
    val current_price: Int,
    val id: Int,
    val modified: String,
    val orderdetails: List<Orderdetail>,
    val product: ProductX,
    val product_id: Int,
    val size: String,
    val start_price: Int,
    val total_result: Int
)