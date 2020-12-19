package com.codesroots.osamaomar.shopgate.entities

class SubCategriesWithProducts {

    var data: List<DataBean>? = null
    var productsbyrate: List<ProductsbyrateBean>? = null



    class ProductsbyrateBean {

        var total_result: Int = 0
        var id: Int = 0
        var start_price: String? = null
        var product_id: Int = 0
        var size: String? = null
        private val img: String? = null
        var created: String? = null
        var modified: String? = null
        var current_price: String? = null
        var amount: Int = 0
        var product: ProductBean? = null
        var orderdetails: List<OrderdetailsBean>? = null

        class ProductBean {
            /**
             * id : 31
             * name : zzzz
             * name_en : salt
             * cat_id : 2
             * subcat_id : 2
             * color_hex : #408080
             * created : 2019-02-19T08:20:47+0000
             * modified : 2019-02-19T08:20:47+0000
             * description : axa
             * description_en : xaxa
             * red : 64
             * green : 128
             * blue : 128
             * visible : null
             * favourites : [{"id":73,"product_id":31,"user_id":2}]
             * total_rating : [{"product_id":31,"stars":5,"count":2}]
             * productphotos : [{"product_id":31,"id":20,"photo":"http://shopgate.codesroots.com/library/attachment/1550745371906943104.jpg"}]
             */

            var id: Int = 0
            var name: String? = null
            var name_en: String? = null
            var cat_id: Int = 0
            var subcat_id: Int = 0
            var color_hex: String? = null
            var created: String? = null
            var modified: String? = null
            var description: String? = null
            var description_en: String? = null
            var img: String? = null
            var red: String? = null
            var green: String? = null
            var blue: String? = null
            var visible: Any? = null
            var favourites: List<FavouritesBean>? = null
            var total_rating: List<TotalRatingBean>? = null
            var productphotos: List<ProductphotosBean>? = null

            class FavouritesBean(
                    /**
                     * id : 73
                     * product_id : 31
                     * user_id : 2
                     */


                    var id: Int) {
                var product_id: Int = 0
                var user_id: Int = 0
            }


        }

        class OrderdetailsBean {
            /**
             * productsize_id : 3
             * order_id : 2
             * count : 4
             */

            var productsize_id: Int = 0
            var order_id: Int = 0
            var count: Int = 0
        }
    }
}
