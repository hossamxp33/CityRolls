package com.codesroots.osamaomar.cityrolls.entities

data class Productsbysale(
        val amount: Int,
        val created: String,
        val current_price: Float,
        val id: Int,
        val modified: String,
        val orderdetails: List<Orderdetail>,
        val product: Product,
        val product_id: Int,
        val size: String,
        val start_price: Int,
        val total_result: Int
)

