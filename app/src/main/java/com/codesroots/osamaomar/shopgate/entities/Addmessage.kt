package com.codesroots.osamaomar.shopgate.entities

class Addmessage {


    /**
     * chatting : {"user_id":1,"sender":1,"message_text":"message","chat_id":11}
     */

    var chatting: ChattingBean? = null

    class ChattingBean {
        /**
         * user_id : 1
         * sender : 1
         * message_text : message
         * chat_id : 11
         */

        var user_id: Int = 0
        var sender: Int = 0
        var message_text: String? = null
        var chat_id: Int = 0
    }
}
