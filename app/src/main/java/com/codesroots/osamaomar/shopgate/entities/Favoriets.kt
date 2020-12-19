package com.codesroots.osamaomar.shopgate.entities

class Favoriets {
    var data: List<DataBean>? = null
    class DataBean {
        /**
         * id : 3
         * user_id : 2
         * product_id : 31
         * product : {"id":31,"name":"zzzz","name_en":"salt","total_rating":[{"product_id":31,"stars":3,"count":1}],"productsizes":[{"id":3,"size":"100","product_id":31,"amount":1,"start_price":"1"}],"productphotos":[{"id":20,"photo":"http://shopgate.codesroots.com/library/attachment/1550745371906943104.jpg","product_id":31}]}
         */

        var id: Int = 0
        var user_id: Int = 0
        var product_id: Int = 0
        var product: ProductBean? = null


    }
}
