package com.codesroots.osamaomar.shopgate.entities

data class MainView(
    val category: List<Category>,
    val currency: Currency,
    val newdata: List<Newdata>,
    val offernew: List<Offernew>,
    val productsbysales: List<Productsbysale>,
    val sliders: List<Slider>
)