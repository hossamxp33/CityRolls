package com.codesroots.osamaomar.cityrolls.helper

import com.codesroots.osamaomar.cityrolls.entities.Productsize

public class kotlinusercase {


    fun makestringarray(list: List<Productsize>) : List<String> {
      return  list.map { e -> e.size }


    }
//    fun makestringarrayForColor(list: List<ProductColor>) : List<String> {
//        return  list.map { e -> e.color }
//
//
//    }

}