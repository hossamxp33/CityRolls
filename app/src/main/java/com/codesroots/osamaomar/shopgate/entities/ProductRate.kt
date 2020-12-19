package com.codesroots.osamaomar.shopgate.entities

class ProductRate {


    var data: List<DataBean>? = null

    class DataBean {
        /**
         * id : 30
         * name : zzzz
         * name_en : salt
         * productrates : [{"id":4,"user_id":5,"rate":3,"created":"2019-03-20T11:45:26+0000","modified":"2019-03-20T11:45:26+0000","comment":"gamel gdn","product_id":30,"user":{"id":5,"username":"admin"}},{"id":5,"user_id":5,"rate":3,"created":"2019-03-20T12:55:10+0000","modified":"2019-03-20T12:55:10+0000","comment":"gamel gdn","product_id":30,"user":{"id":5,"username":"admin"}},{"id":6,"user_id":5,"rate":5,"created":"2019-03-20T12:56:05+0000","modified":"2019-03-20T12:56:05+0000","comment":"gftjgft","product_id":30,"user":{"id":5,"username":"admin"}},{"id":7,"user_id":5,"rate":5,"created":"2019-03-20T13:02:36+0000","modified":"2019-03-20T13:02:36+0000","comment":"gftjgft","product_id":30,"user":{"id":5,"username":"admin"}},{"id":8,"user_id":5,"rate":3.5,"created":"2019-03-20T13:18:50+0000","modified":"2019-03-20T13:18:50+0000","comment":"gamel gdn","product_id":30,"user":{"id":5,"username":"admin"}},{"id":9,"user_id":5,"rate":0,"created":"2019-03-20T13:18:53+0000","modified":"2019-03-20T13:18:53+0000","comment":"تلب","product_id":30,"user":{"id":5,"username":"admin"}},{"id":10,"user_id":5,"rate":2.5,"created":"2019-03-20T13:19:19+0000","modified":"2019-03-20T13:19:19+0000","comment":"التقييم جيد جدا ","product_id":30,"user":{"id":5,"username":"admin"}},{"id":11,"user_id":5,"rate":3,"created":"2019-03-20T13:23:17+0000","modified":"2019-03-20T13:23:17+0000","comment":"المنتج جيد جدا ","product_id":30,"user":{"id":5,"username":"admin"}}]
         * total_rating : [{"product_id":30,"stars":25,"count":8}]
         */

        var id: Int = 0
        var name: String? = null
        var name_en: String? = null
        var productrates: List<ProductratesBean>? = null
        var total_rating: List<TotalRatingBean>? = null

        class ProductratesBean {
            /**
             * id : 4
             * user_id : 5
             * rate : 3
             * created : 2019-03-20T11:45:26+0000
             * modified : 2019-03-20T11:45:26+0000
             * comment : gamel gdn
             * product_id : 30
             * user : {"id":5,"username":"admin"}
             */

            var id: Int = 0
            var user_id: Int = 0
            var rate: Float = 0.toFloat()
                private set
            var created: String? = null
            var modified: String? = null
            var comment: String? = null
            var product_id: Int = 0
            var user: UserBean? = null

            fun setRate(rate: Int) {
                this.rate = rate.toFloat()
            }

            class UserBean {
                /**
                 * id : 5
                 * username : admin
                 */

                var id: Int = 0
                var username: String? = null
            }
        }

    }
}
