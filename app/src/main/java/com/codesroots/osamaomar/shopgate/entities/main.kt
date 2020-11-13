package com.codesroots.osamaomar.shopgate.entities

data class main(
        val category: List<Category>,
        val currency: Currency,
        val newdata: List<MainView.Newdata>,
        val offernew: List<Offernew>,
        val productsbysales: List<Productsbysale>,
        val sliders: List<Slider>
)