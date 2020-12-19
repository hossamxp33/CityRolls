package com.codesroots.osamaomar.shopgate.helper

import com.codesroots.osamaomar.shopgate.entities.ProductColor
import com.codesroots.osamaomar.shopgate.entities.ProductDetails
import com.codesroots.osamaomar.shopgate.entities.Productsize

public class kotlinusercase {


    fun makestringarray(list: List<Productsize>) : List<String> {
      return  list.map { e -> e.size }


    }
    fun makestringarrayForColor(list: List<ProductColor>) : List<String> {
        return  list.map { e -> e.color }


    }

}