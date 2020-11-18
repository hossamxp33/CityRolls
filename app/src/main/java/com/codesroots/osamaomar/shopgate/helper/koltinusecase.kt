package com.codesroots.osamaomar.shopgate.helper

import com.codesroots.osamaomar.shopgate.entities.ProductDetails

public class kotlinusercase {


    fun makestringarray(list: List<ProductDetails.ProductdetailsBean.ProductsizesBean>) : List<String> {
      return  list.map { e -> e.size }


    }
}