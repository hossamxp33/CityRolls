package com.codesroots.osamaomar.cityrolls.entities

class CartItems {


    var data: List<DataBean>? = null

    class DataBean {
        /**
         * id : 4
         * amount : 4
         * product_id : 32
         * start_price : 400
         * product : {"id":32,"name":"zzzz","name_en":"salt","description":"axa","description_en":"xaxa","total_rating":[{"product_id":32,"stars":6,"count":2}],"offers":[{"id":2,"product_id":32,"percentage":"20"}],"productphotos":[{"id":4,"product_id":32,"photo":"http://shopgate.codesroots.com/library/attachment/pd4.jpg"}]}
         */

        var id: Int = 0
        var amount: Int = 0
        var product_id: Int = 0
        var current_price: Int = 0
        var product: ProductBean? = null



        class ProductBean {

            var id: Int = 0
            var name: String? = null
            var name_en: String? = null
            var img: String? = null
            var description: String? = null
            var description_en: String? = null
            var productsizes: List<Productsize>? = null
            var total_rating: List<TotalRatingBean>? = null
            var productphotos: List<ProductphotosBean>? = null
            var offers: List<OffersBean>? = null
            var favourites: List<FavouritesBean>? = null







            class OffersBean {
                /**
                 * id : 4
                 * percentage : 30
                 * product_id : 31
                 */

                var id: Int = 0
                var percentage: String? = null
                var product_id: Int = 0
            }

            class FavouritesBean {
                /**
                 * product_id : 31
                 * id : 1
                 * user_id : 2
                 */

                var product_id: Int = 0
                var id: Int = 0
                var user_id: Int = 0

            }
        }
    }
}
