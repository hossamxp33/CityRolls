package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class ChatList {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        public DataBean(int sender, String message_text, String dated) {
            this.sender = sender;
            this.message_text = message_text;
            this.dated = dated;
        }

        /**
         * chat_id : 1
         * user_id : 1
         * sender : 8
         * message_text : hi
         * dated : 2019-05-08T11:27:16+0000
         */


        private int chat_id;
        private int user_id;
        private int sender;
        private String message_text;
        private String dated;

        public int getChat_id() {
            return chat_id;
        }

        public void setChat_id(int chat_id) {
            this.chat_id = chat_id;
        }

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

        public String getDated() {
            return dated;
        }

        public void setDated(String dated) {
            this.dated = dated;
        }
    }
}
