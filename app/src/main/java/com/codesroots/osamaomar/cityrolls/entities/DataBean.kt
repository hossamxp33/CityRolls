package com.codesroots.osamaomar.cityrolls.entities

data class DataBean(
        val basic_value: Int,
        val id: Int,
        val name: String,
        val name_ar: String,
        val value: Float,
        var photo: String? = null
)