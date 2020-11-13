package com.codesroots.osamaomar.shopgate.entities;

public class Register {

    /**
     * success : true
     * user_id : 281
     * delivery_id : 106
     */

    private boolean success;
    private int user_id;
    private int delivery_id;
    /**
     * data : {"id":25,"username":"osama","photo":null,"code":200,"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjI1LCJleHAiOjE1NTU1MTgyNzF9.b6AloBuijHYaYdgBugwjr3ca6zBLdms1zjVzyOOVc9s"}
     */

    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 25
         * username : osama
         * photo : null
         * code : 200
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjI1LCJleHAiOjE1NTU1MTgyNzF9.b6AloBuijHYaYdgBugwjr3ca6zBLdms1zjVzyOOVc9s
         */

        private int id;
        private String username;
        private Object photo;
        private int code;
        private String token;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Object getPhoto() {
            return photo;
        }

        public void setPhoto(Object photo) {
            this.photo = photo;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}


