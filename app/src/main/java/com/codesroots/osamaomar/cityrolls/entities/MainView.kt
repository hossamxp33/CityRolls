package com.codesroots.osamaomar.cityrolls.entities

data class MainView(
    val items: List<Category>,
    val currency: Currency,
    val newdata: List<Newdata>,
    val offernew: List<Offernew>,
    val productsbysales: List<Productsbysale>,
    val sliders: List<Slider>
)