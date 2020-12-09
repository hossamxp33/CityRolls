package com.codesroots.osamaomar.shopgate.entities;

import java.util.List;

public class UserLocations {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
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

        private int billing_id;
        private int user_id;
        private String first_name;
        private String last_name;
        private String company_name;
        private String address;
        private String town_city;
        private String state_country;
        private String post_zip;
        private String email_address;
        private String phone;
        private int status;
        private String created_at;
        private String updated_at;
        private String lat;
        private String lng;

        public int getBilling_id() {
            return billing_id;
        }

        public void setBilling_id(int billing_id) {
            this.billing_id = billing_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTown_city() {
            return town_city;
        }

        public void setTown_city(String town_city) {
            this.town_city = town_city;
        }

        public String getState_country() {
            return state_country;
        }

        public void setState_country(String state_country) {
            this.state_country = state_country;
        }

        public String getPost_zip() {
            return post_zip;
        }

        public void setPost_zip(String post_zip) {
            this.post_zip = post_zip;
        }

        public String getEmail_address() {
            return email_address;
        }

        public void setEmail_address(String email_address) {
            this.email_address = email_address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }
    }
}
