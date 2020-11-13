package com.codesroots.osamaomar.shopgate.entities;

public class Addmessage {


    /**
     * chatting : {"user_id":1,"sender":1,"message_text":"message","chat_id":11}
     */

    private ChattingBean chatting;

    public ChattingBean getChatting() {
        return chatting;
    }

    public void setChatting(ChattingBean chatting) {
        this.chatting = chatting;
    }

    public static class ChattingBean {
        /**
         * user_id : 1
         * sender : 1
         * message_text : message
         * chat_id : 11
         */

        private int user_id;
        private int sender;
        private String message_text;
        private int chat_id;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getSender() {
            return sender;
        }

        public void setSender(int sender) {
            this.sender = sender;
        }

        public String getMessage_text() {
            return message_text;
        }

        public void setMessage_text(String message_text) {
            this.message_text = message_text;
        }

        public int getChat_id() {
            return chat_id;
        }

        public void setChat_id(int chat_id) {
            this.chat_id = chat_id;
        }
    }
}
