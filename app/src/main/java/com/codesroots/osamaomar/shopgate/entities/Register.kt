package com.codesroots.osamaomar.shopgate.entities

class Register {

    /**
     * success : true
     * user_id : 281
     * delivery_id : 106
     */

    var isSuccess: Boolean = false
    var user_id: Int = 0
    var delivery_id: Int = 0
    /**
     * data : {"id":25,"username":"osama","photo":null,"code":200,"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjI1LCJleHAiOjE1NTU1MTgyNzF9.b6AloBuijHYaYdgBugwjr3ca6zBLdms1zjVzyOOVc9s"}
     */

    var data: DataBean? = null

    class DataBean {
        /**
         * id : 25
         * username : osama
         * photo : null
         * code : 200
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjI1LCJleHAiOjE1NTU1MTgyNzF9.b6AloBuijHYaYdgBugwjr3ca6zBLdms1zjVzyOOVc9s
         */

        var id: Int = 0
        var username: String? = null
        var photo: Any? = null
        var code: Int = 0
        var token: String? = null
    }
}


