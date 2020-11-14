package com.codesroots.osamaomar.shopgate.entities

data class kotlin_product_details(
    val cat: Int,
    val productdetails: List<Productdetail>,
    val related: List<Related>,
    val subcat: Int
)