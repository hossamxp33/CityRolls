package com.codesroots.osamaomar.shopgate.entities

data class Countries(
    val curr: List<DataBean>,
    val `data`: List<CountriesData>
)
data class CountriesData(
        val code: String,
        val created: Any,
        val id: Int,
        val modified: String,
        val name: String,
        val name_en: String
)