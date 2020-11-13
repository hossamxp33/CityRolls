package com.codesroots.osamaomar.shopgate.entities;

public class LoginResponse {


    /**
     * success : true
     * data : {"id":5,"username":"admin","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjUsImV4cCI6MTU1NTUxOTM1N30.vQFx5wAdDKPcMqHixwdIq7z5hQK0dLm5rXo4g-VHLek"}
     */

    private boolean success;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 5
         * username : admin
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjUsImV4cCI6MTU1NTUxOTM1N30.vQFx5wAdDKPcMqHixwdIq7z5hQK0dLm5rXo4g-VHLek
         */

        private int id;
        private String username;
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

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
