package com.codesroots.osamaomar.cityrolls.entities

class offers {

    var data: List<DataBean>? = null

    class DataBean {
        /**
         * id : 3
         * percentage : 20
         * product_id : 41
         * end_date : 04/24/2019
         * product : {"id":41,"name":"dwe","name_en":"petadin","description":"xasxas","description_en":"xasxas","productsizes":[{"id":13,"amount":3,"start_price":"100","product_id":41}],"productphotos":[{"id":13,"photo":"http://shopgate.codesroots.com/library/attachment/pd13.jpg","product_id":41}],"total_rating":[{"product_id":41,"stars":2,"count":1}]}
         */

        var id: Int = 0
        var percentage = "1"
            get() = if (field.matches("".toRegex()))
                "1"
            else
                field
        var product_id: Int = 0
        var end_date: String? = null
        var product: ProductBean? = null

    }
}
