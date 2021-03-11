package com.codesroots.osamaomar.cityrolls.entities

class UserLocations {


    var data: List<DataBean>? = null

    class DataBean {
        /**
         * billing_id : 1
         * user_id : 1
         * first_name : asd
         * last_name : asd
         * company_name : asdasd
         * address : asdasdasd
         * town_city : asdasd
         * state_country : asd
         * post_zip : asdasd
         * email_address : asdasd
         * phone : 12341234
         * status : 0
         * created_at : 2019-05-07T23:29:04+0000
         * updated_at : 2019-05-07T23:29:04+0000
         * lat : 0
         * lng : 0
         */

        var billing_id: Int = 0
        var user_id: Int = 0
        var first_name: String? = null
        var last_name: String? = null
        var company_name: String? = null
        var address: String? = null
        var town_city: String? = null
        var state_country: String? = null
        var post_zip: String? = null
        var email_address: String? = null
        var phone: String? = null
        var status: Int = 0
        var created_at: String? = null
        var updated_at: String? = null
        var lat: String? = null
        var lng: String? = null
    }
}
