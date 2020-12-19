package com.codesroots.osamaomar.shopgate.entities

class AddToFavModel {


    /**
     * postlike : {"user_id":115,"product_id":22,"created":"2019-06-23T10:22:59+0000","modified":"2019-06-23T10:22:59+0000","id":92}
     * likeid : 92
     */

    var postlike: PostlikeBean? = null
    var likeid: Int = 0

    class PostlikeBean {
        /**
         * user_id : 115
         * product_id : 22
         * created : 2019-06-23T10:22:59+0000
         * modified : 2019-06-23T10:22:59+0000
         * id : 92
         */

        var user_id: Int = 0
        var product_id: Int = 0
        var created: String? = null
        var modified: String? = null
        var id: Int = 0
    }
}
